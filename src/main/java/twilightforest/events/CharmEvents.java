package twilightforest.events;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Tuple;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.FluidState;
import twilightforest.TFConfig;
import twilightforest.TwilightForestMod;
import twilightforest.block.KeepsakeCasketBlock;
import twilightforest.block.entity.KeepsakeCasketBlockEntity;
import twilightforest.data.tags.ItemTagGenerator;
import twilightforest.entity.CharmEffect;
import twilightforest.enums.BlockLoggingEnum;
import twilightforest.init.*;
import twilightforest.util.TFItemStackUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CharmEvents {

	public static final String CHARM_INV_TAG = "TFCharmInventory";
	//stores if the casket was planned to break on respawn
	private static boolean casketExpiration = false;
	//stores the charm that was used for the effect later
	public static ItemStack charmUsed;

	public static void init() {
		ServerPlayerEvents.AFTER_RESPAWN.register(CharmEvents::onPlayerRespawn);
		// have our death event run late only apply if nothing else prevents death first
		ResourceLocation late = TwilightForestMod.prefix("late");
		ServerPlayerEvents.ALLOW_DEATH.addPhaseOrdering(Event.DEFAULT_PHASE, late);
		ServerPlayerEvents.ALLOW_DEATH.register(late, CharmEvents::applyDeathItems);
	}

	// For when the player dies
	public static boolean applyDeathItems(ServerPlayer player, DamageSource damageSource, float damageAmount) {
		//ensure our player is real and in survival before attempting anything
		if (player.level().isClientSide() || (player.getClass() != ServerPlayer.class) || player.isFake() ||
				player.isCreative() || player.isSpectator()) return true;

		if (charmOfLife(player)) {
			return false; // Executes if the player had charms
		} else if (!player.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
			// Did the player recover? No? Let's give them their stuff based on the keeping charms
			charmOfKeeping(player);

			// Then let's store the rest of their stuff in the casket
			keepsakeCasket(player);
		}
		return true;
	}

	public static void onPlayerRespawn(ServerPlayer oldPlayer, ServerPlayer newPlayer, boolean alive) {
		if (!alive) {
			if (casketExpiration) {
				newPlayer.sendSystemMessage(Component.translatable("block.twilightforest.casket.broken").withStyle(ChatFormatting.RED));
				casketExpiration = false;
			}
			returnStoredItems(newPlayer);
		}
	}

	private static boolean charmOfLife(Player player) {
		boolean charm2 = TFItemStackUtils.consumeInventoryItem(player, TFItems.CHARM_OF_LIFE_2.get()) || hasCharmCurio(TFItems.CHARM_OF_LIFE_2.get(), player);
		boolean charm1 = !charm2 && (TFItemStackUtils.consumeInventoryItem(player, TFItems.CHARM_OF_LIFE_1.get()) || hasCharmCurio(TFItems.CHARM_OF_LIFE_1.get(), player));

		if (charm2 || charm1) {
			if (charm1) {
				player.setHealth(8);
				player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
			}

			if (charm2) {
				player.setHealth(player.getMaxHealth());

				player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 3));
				player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0));
				player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0));
			}

			// spawn effect thingers
			CharmEffect effect = new CharmEffect(TFEntities.CHARM_EFFECT.get(), player.level(), player, charm1 ? TFItems.CHARM_OF_LIFE_1.get() : TFItems.CHARM_OF_LIFE_2.get());
			player.level().addFreshEntity(effect);

			CharmEffect effect2 = new CharmEffect(TFEntities.CHARM_EFFECT.get(), player.level(), player, charm1 ? TFItems.CHARM_OF_LIFE_1.get() : TFItems.CHARM_OF_LIFE_2.get());
			effect2.offset = (float) Math.PI;
			player.level().addFreshEntity(effect2);

			player.level().playSound(null, player.getX(), player.getY(), player.getZ(), TFSounds.CHARM_LIFE.get(), player.getSoundSource(), 1, 1);

			if (player instanceof ServerPlayer) player.awardStat(TFStats.LIFE_CHARMS_ACTIVATED.get());

			return true;
		}

		return false;
	}

	private static void charmOfKeeping(Player player) {
		//check our inventory for any charms of keeping. We also want to check curio slots (if the mod is installed)
		// TODO also consider situations where the actual slots may be empty, and charm gets consumed anyway. Usually won't happen.
		boolean tier3 = TFItemStackUtils.consumeInventoryItem(player, TFItems.CHARM_OF_KEEPING_3.get()) || hasCharmCurio(TFItems.CHARM_OF_KEEPING_3.get(), player);
		boolean tier2 = tier3 || TFItemStackUtils.consumeInventoryItem(player, TFItems.CHARM_OF_KEEPING_2.get()) || hasCharmCurio(TFItems.CHARM_OF_KEEPING_2.get(), player);
		boolean tier1 = tier2 || TFItemStackUtils.consumeInventoryItem(player, TFItems.CHARM_OF_KEEPING_1.get()) || hasCharmCurio(TFItems.CHARM_OF_KEEPING_1.get(), player);

		//create a fake inventory to organize our kept inventory in
		Inventory keepInventory = new Inventory(null);
		ListTag tagList = new ListTag();

		//if we have any charm of keeping, all armor and offhand items are kept, so add those
		if (tier1) {
			keepWholeList(keepInventory.armor, player.getInventory().armor);
			keepWholeList(keepInventory.offhand, player.getInventory().offhand);
		}

		if (tier3) {
			//tier 3 keeps our entire inventory
			keepWholeList(keepInventory.items, player.getInventory().items);
			charmUsed = new ItemStack(TFItems.CHARM_OF_KEEPING_3.get());
		} else if (tier2) {
			//tier 2 keeps our hotbar only
			for (int i = 0; i < 9; i++) {
				keepInventory.items.set(i, player.getInventory().items.get(i).copy());
				player.getInventory().items.set(i, ItemStack.EMPTY);
			}
			charmUsed = new ItemStack(TFItems.CHARM_OF_KEEPING_2.get());
		} else if (tier1) {
			//tier 1 keeps our selected item only
			int i = player.getInventory().selected;
			if (Inventory.isHotbarSlot(i)) {
				keepInventory.items.set(i, player.getInventory().items.get(i).copy());
				player.getInventory().items.set(i, ItemStack.EMPTY);
			}
			charmUsed = new ItemStack(TFItems.CHARM_OF_KEEPING_1.get());
		}

		//keep all items in the kept_on_death tag. This allows modpacks to support other items to keep on death
		for (int i = 0; i < player.getInventory().items.size(); i++) {
			ItemStack stack = player.getInventory().items.get(i);
			if (stack.is(ItemTagGenerator.KEPT_ON_DEATH)) {
				keepInventory.items.set(i, stack.copy());
				player.getInventory().items.set(i, ItemStack.EMPTY);
			}
		}

		for (int i = 0; i < player.getInventory().armor.size(); i++) {
			ItemStack armor = player.getInventory().armor.get(i);
			if (armor.is(ItemTagGenerator.KEPT_ON_DEATH)) {
				keepInventory.armor.set(i, armor.copy());
				player.getInventory().armor.set(i, ItemStack.EMPTY);
			}
		}

		if (player.getInventory().offhand.get(0).is(ItemTagGenerator.KEPT_ON_DEATH)) {
			keepInventory.offhand.set(0, player.getInventory().offhand.get(0).copy());
			player.getInventory().offhand.set(0, ItemStack.EMPTY);
		}

		//take our fake inventory and save it to the persistent player data.
		//by saving it there we can guarantee we will always get all of our items back, even if the player logs out and back in.
		if (!keepInventory.isEmpty()) {
			keepInventory.save(tagList);
			getPlayerData(player).put(CHARM_INV_TAG, tagList);
		}
	}

	private static void keepsakeCasket(Player player) {
		//reset this just in case. I was having fresh caskets place as the max damaged ones
		TFItemStackUtils.damage = 0;
		boolean casketConsumed = TFItemStackUtils.consumeInventoryItem(player, TFBlocks.KEEPSAKE_CASKET.get().asItem());

		if (casketConsumed) {
			Level level = player.getCommandSenderWorld();
			BlockPos.MutableBlockPos pos = player.blockPosition().mutable();

			if (pos.getY() < level.dimensionType().minY() + 2) {
				pos.setY(level.dimensionType().minY() + 2);
			} else {
				int logicalHeight = player.getCommandSenderWorld().dimensionType().logicalHeight();

				if (pos.getY() > logicalHeight) {
					pos.setY(logicalHeight - 1);
				}
			}

			pos.move(0, -1, 0);

			do {
				pos.move(0, 1, 0);
			} while (!level.getBlockState(pos).canBeReplaced());

			BlockPos immutablePos = pos.immutable();
			FluidState fluidState = level.getFluidState(immutablePos);

			if (level.setBlockAndUpdate(immutablePos, TFBlocks.KEEPSAKE_CASKET.get().defaultBlockState().setValue(BlockLoggingEnum.MULTILOGGED, BlockLoggingEnum.getFromFluid(fluidState.getType())).setValue(KeepsakeCasketBlock.BREAKAGE, TFItemStackUtils.damage).setValue(KeepsakeCasketBlock.FACING, Direction.from2DDataValue(level.getRandom().nextInt(3))))) {
				BlockEntity te = level.getBlockEntity(immutablePos);

				if (te instanceof KeepsakeCasketBlockEntity casket) {
					if (TFConfig.COMMON_CONFIG.casketUUIDLocking.get()) {
						//make it so only the player who died can open the chest if our config allows us
						casket.playeruuid = player.getGameProfile().getId();
					} else {
						casket.playeruuid = null;
					}

					//some names are way too long for the casket so we'll cut them down
					String modifiedName;
					if (player.getName().getString().length() > 12)
						modifiedName = player.getName().getString().substring(0, 12);
					else modifiedName = player.getName().getString();
					casket.name = player.getName().getString();
					casket.casketname = modifiedName;
					casket.setCustomName(Component.literal(modifiedName + "'s " + (level.getRandom().nextInt(1000) == 0 ? "Costco Casket" : casket.getDisplayName().getString())));
					int damage = level.getBlockState(immutablePos).getValue(KeepsakeCasketBlock.BREAKAGE);
					if (level.getRandom().nextFloat() <= 0.15F) {
						if (damage >= 2) {
							player.getInventory().dropAll();
							level.setBlockAndUpdate(immutablePos, Blocks.AIR.defaultBlockState());
							casketExpiration = true;
							TwilightForestMod.LOGGER.debug("{}'s Casket damage value was too high, alerting the player and dropping extra items", player.getName().getString());
						} else {
							damage = damage + 1;
							level.setBlockAndUpdate(immutablePos, TFBlocks.KEEPSAKE_CASKET.get().defaultBlockState().setValue(BlockLoggingEnum.MULTILOGGED, BlockLoggingEnum.getFromFluid(fluidState.getType())).setValue(KeepsakeCasketBlock.BREAKAGE, damage));
							TwilightForestMod.LOGGER.debug("{}'s Casket was randomly damaged, applying new damage", player.getName().getString());
						}
					}
					int casketCapacity = casket.getContainerSize();
					List<ItemStack> list = new ArrayList<>(casketCapacity);
					NonNullList<ItemStack> filler = NonNullList.withSize(4, ItemStack.EMPTY);

					// lets add our inventory exactly how it was on us
					list.addAll(TFItemStackUtils.sortArmorForCasket(player));
					player.getInventory().armor.clear();
					list.addAll(filler);
					list.addAll(player.getInventory().offhand);
					player.getInventory().offhand.clear();
					list.addAll(TFItemStackUtils.sortInvForCasket(player));
					player.getInventory().items.clear();

					casket.setItems(NonNullList.of(ItemStack.EMPTY, list.toArray(new ItemStack[casketCapacity])));
				}
			} else {
				TwilightForestMod.LOGGER.error("Could not place Keepsake Casket at " + pos);
			}
		}
	}

	/**
	 * Maybe we kept some stuff for the player!
	 */
	private static void returnStoredItems(Player player) {

		TwilightForestMod.LOGGER.debug("Player {} ({}) respawned and received items held in storage", player.getName().getString(), player.getUUID());

		//check if our tag is in the persistent player data. If so, copy that inventory over to our own. Cloud storage at its finest!
		CompoundTag playerData = getPlayerData(player);
		if (!player.level().isClientSide() && playerData.contains(CHARM_INV_TAG)) {
			ListTag tagList = playerData.getList(CHARM_INV_TAG, 10);
			TFItemStackUtils.loadNoClear(tagList, player.getInventory());
			getPlayerData(player).getList(CHARM_INV_TAG, 10).clear();
			getPlayerData(player).remove(CHARM_INV_TAG);
		}

		// spawn effect thingers
		if (charmUsed != null) {
			CharmEffect effect = new CharmEffect(TFEntities.CHARM_EFFECT.get(), player.level(), player, charmUsed.getItem());
			player.level().addFreshEntity(effect);

			CharmEffect effect2 = new CharmEffect(TFEntities.CHARM_EFFECT.get(), player.level(), player, charmUsed.getItem());
			effect2.offset = (float) Math.PI;
			player.level().addFreshEntity(effect2);

			player.level().playSound(null, player.getX(), player.getY(), player.getZ(), TFSounds.CHARM_KEEP.get(), player.getSoundSource(), 1.5F, 1.0F);
			if (player instanceof ServerPlayer) player.awardStat(TFStats.KEEPING_CHARMS_ACTIVATED.get());
			charmUsed = null;
		}
	}

	public static CompoundTag getPlayerData(Player player) {
		if (!player.getExtraCustomData().contains("PlayerPersisted")) {
			player.getExtraCustomData().put("PlayerPersisted", new CompoundTag());
		}
		return player.getExtraCustomData().getCompound("PlayerPersisted");
	}

	//transfers a list of items to another
	private static void keepWholeList(NonNullList<ItemStack> transferTo, NonNullList<ItemStack> transferFrom) {
		for (int i = 0; i < transferFrom.size(); i++) {
			transferTo.set(i, transferFrom.get(i).copy());
		}
		transferFrom.clear();
	}

	private static boolean hasCharmCurio(Item item, Player player) {
		if(FabricLoader.getInstance().isModLoaded("trinkets")) {
			List<Tuple<SlotReference, ItemStack>> slots = player.getComponent(TrinketsApi.TRINKET_COMPONENT).getEquipped(stack -> stack.is(item));

			if (!slots.isEmpty() && !slots.get(0).getB().isEmpty()) {
				slots.get(0).getB().shrink(1);
				return true;
			}
		}

		return false;
	}

}
