package twilightforest.init;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.LazySpawnEggItem;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import twilightforest.TwilightForestMod;
import twilightforest.entity.*;
import twilightforest.entity.boss.*;
import twilightforest.entity.monster.*;
import twilightforest.entity.passive.*;
import twilightforest.entity.projectile.*;

public class TFEntities {

	public static final LazyRegistrar<EntityType<?>> ENTITIES = LazyRegistrar.create(Registries.ENTITY_TYPE, TwilightForestMod.ID);
	public static final LazyRegistrar<Item> SPAWN_EGGS = LazyRegistrar.create(Registries.ITEM, TwilightForestMod.ID);

	public static final RegistryObject<EntityType<Adherent>> ADHERENT = make(TFEntityNames.ADHERENT, Adherent::new, MobCategory.MONSTER, 0.8F, 2.2F, 0x0a0000, 0x00008b);
	public static final RegistryObject<EntityType<AlphaYeti>> ALPHA_YETI = make(TFEntityNames.ALPHA_YETI, AlphaYeti::new, MobCategory.MONSTER, 3.8F, 5.0F, 0xcdcdcd, 0x29486e);
	public static final RegistryObject<EntityType<ArmoredGiant>> ARMORED_GIANT = make(TFEntityNames.ARMORED_GIANT, ArmoredGiant::new, MobCategory.MONSTER, 2.4F, 7.2F, 0x239391, 0x9a9a9a);
	public static final RegistryObject<EntityType<Bighorn>> BIGHORN_SHEEP = make(TFEntityNames.BIGHORN_SHEEP, Bighorn::new, MobCategory.CREATURE, 0.9F, 1.3F, 0xdbceaf, 0xd7c771);
	public static final RegistryObject<EntityType<BlockChainGoblin>> BLOCKCHAIN_GOBLIN = make(TFEntityNames.BLOCKCHAIN_GOBLIN, BlockChainGoblin::new, MobCategory.MONSTER, 0.9F, 1.4F, 0xd3e7bc, 0x1f3fff);
	public static final RegistryObject<EntityType<Boar>> BOAR = make(TFEntityNames.BOAR, Boar::new, MobCategory.CREATURE, 0.9F, 0.9F, 0x83653b, 0xffefca);
	public static final RegistryObject<EntityType<TwilightBoat>> BOAT = buildNoEgg(TFEntityNames.BOAT, makeCastedBuilder(TwilightBoat.class, TwilightBoat::new, 1.375F, 0.5625F, 10, 3), false);
	//public static final RegistryObject<EntityType<Boggard>> BOGGARD = make(TFEntityNames.BOGGARD, Boggard::new, MobCategory.MONSTER, 0.8F, 1.1F);
	public static final RegistryObject<EntityType<TowerBroodling>> CARMINITE_BROODLING = make(TFEntityNames.CARMINITE_BROODLING, TowerBroodling::new, MobCategory.MONSTER, 0.7F, 0.5F, 0x343c14, 0xbaee02);
	public static final RegistryObject<EntityType<CarminiteGhastguard>> CARMINITE_GHASTGUARD = make(TFEntityNames.CARMINITE_GHASTGUARD, CarminiteGhastguard::new, MobCategory.MONSTER, 4.0F, 6.0F, 0xbcbcbc, 0xb77878);
	public static final RegistryObject<EntityType<CarminiteGhastling>> CARMINITE_GHASTLING = make(TFEntityNames.CARMINITE_GHASTLING, CarminiteGhastling::new, MobCategory.MONSTER, 1.1F, 1.5F, 0xbcbcbc, 0xa74343);
	public static final RegistryObject<EntityType<CarminiteGolem>> CARMINITE_GOLEM = make(TFEntityNames.CARMINITE_GOLEM, CarminiteGolem::new, MobCategory.MONSTER, 1.4F, 2.9F, 0x6b3d20, 0xe2ddda);
	public static final RegistryObject<EntityType<ChainBlock>> CHAIN_BLOCK = buildNoEgg(TFEntityNames.CHAIN_BLOCK, makeCastedBuilder(ChainBlock.class, ChainBlock::new, 0.6F, 0.6F, 80, 1), true);
	public static final RegistryObject<EntityType<CharmEffect>> CHARM_EFFECT = make(TFEntityNames.CHARM_EFFECT, CharmEffect::new, MobCategory.MISC, 0.25F, 0.25F, 0, 0);
	public static final RegistryObject<EntityType<TwilightChestBoat>> CHEST_BOAT = buildNoEgg(TFEntityNames.CHEST_BOAT, makeCastedBuilder(TwilightChestBoat.class, TwilightChestBoat::new, 1.375F, 0.5625F, 10, 3), false);
	public static final RegistryObject<EntityType<CubeOfAnnihilation>> CUBE_OF_ANNIHILATION = buildNoEgg(TFEntityNames.CUBE_OF_ANNIHILATION, makeCastedBuilder(CubeOfAnnihilation.class, CubeOfAnnihilation::new, 1.0F, 1.0F, 80, 1), true);
	public static final RegistryObject<EntityType<DeathTome>> DEATH_TOME = make(TFEntityNames.DEATH_TOME, DeathTome::new, MobCategory.MONSTER, 0.6F, 1.1F, 0x774e22, 0xdbcdbe);
	public static final RegistryObject<EntityType<Deer>> DEER = make(TFEntityNames.DEER, Deer::new, MobCategory.CREATURE, 0.7F, 1.8F, 0x7b4d2e, 0x4b241d);
	public static final RegistryObject<EntityType<DwarfRabbit>> DWARF_RABBIT = make(TFEntityNames.DWARF_RABBIT, DwarfRabbit::new, MobCategory.CREATURE, 0.4F, 0.4F, 0xfefeee, 0xccaa99);
	public static final RegistryObject<EntityType<FallingIce>> FALLING_ICE = make(TFEntityNames.FALLING_ICE, FallingIce::new, MobCategory.MISC, 1.0F, 1.0F, true, 0, 0);
	public static final RegistryObject<EntityType<FireBeetle>> FIRE_BEETLE = make(TFEntityNames.FIRE_BEETLE, FireBeetle::new, MobCategory.MONSTER, 1.1F, 0.5F, true, 0x1d0b00, 0xcb6f25);
	public static final RegistryObject<EntityType<GiantMiner>> GIANT_MINER = make(TFEntityNames.GIANT_MINER, GiantMiner::new, MobCategory.MONSTER, 2.4F, 7.2F, 0x211b52, 0x9a9a9a);
	public static final RegistryObject<EntityType<HarbingerCube>> HARBINGER_CUBE = make(TFEntityNames.HARBINGER_CUBE, HarbingerCube::new, MobCategory.MONSTER, 1.9F, 2.4F, true, 0x00000a, 0x8b0000);
	public static final RegistryObject<EntityType<HedgeSpider>> HEDGE_SPIDER = make(TFEntityNames.HEDGE_SPIDER, HedgeSpider::new, MobCategory.MONSTER, 1.4F, 0.9F, 0x235f13, 0x562653);
	public static final RegistryObject<EntityType<HelmetCrab>> HELMET_CRAB = make(TFEntityNames.HELMET_CRAB, HelmetCrab::new, MobCategory.MONSTER, 0.8F, 1.1F, 0xfb904b, 0xd3e7bc);
	public static final RegistryObject<EntityType<HostileWolf>> HOSTILE_WOLF = make(TFEntityNames.HOSTILE_WOLF, HostileWolf::new, MobCategory.MONSTER, 0.6F, 0.85F, 0xd7d3d3, 0xab1e14);
	public static final RegistryObject<EntityType<Hydra>> HYDRA = make(TFEntityNames.HYDRA, Hydra::new, MobCategory.MONSTER, 16.0F, 12.0F, true, 0x142940, 0x29806b);
	public static final RegistryObject<EntityType<HydraMortar>> HYDRA_MORTAR = buildNoEgg(TFEntityNames.HYDRA_MORTAR, makeCastedBuilder(HydraMortar.class, HydraMortar::new, 0.75F, 0.75F, 150, 3), true);
	public static final RegistryObject<EntityType<IceArrow>> ICE_ARROW = buildNoEgg(TFEntityNames.ICE_ARROW, makeCastedBuilder(IceArrow.class, IceArrow::new, 0.5F, 0.5F, 150, 1), false);
	public static final RegistryObject<EntityType<IceBomb>> THROWN_ICE = buildNoEgg(TFEntityNames.THROWN_ICE, makeCastedBuilder(IceBomb.class, IceBomb::new, 1.0F, 1.0F, 80, 2), true);
	public static final RegistryObject<EntityType<IceCrystal>> ICE_CRYSTAL = make(TFEntityNames.ICE_CRYSTAL, IceCrystal::new, MobCategory.MONSTER, 0.6F, 1.8F, 0xdce9fe, 0xadcafb);
	public static final RegistryObject<EntityType<IceSnowball>> ICE_SNOWBALL = buildNoEgg(TFEntityNames.ICE_SNOWBALL, makeCastedBuilder(IceSnowball.class, IceSnowball::new, 0.25F, 0.25F, 150, 3), false);
	public static final RegistryObject<EntityType<KingSpider>> KING_SPIDER = make(TFEntityNames.KING_SPIDER, KingSpider::new, MobCategory.MONSTER, 1.6F, 1.6F, 0x2c1a0e, 0xffc017);
	public static final RegistryObject<EntityType<KnightPhantom>> KNIGHT_PHANTOM = make(TFEntityNames.KNIGHT_PHANTOM, KnightPhantom::new, MobCategory.MONSTER, 1.25F, 2.5F, 0xa6673b, 0xd3e7bc);
	public static final RegistryObject<EntityType<Kobold>> KOBOLD = make(TFEntityNames.KOBOLD, Kobold::new, MobCategory.MONSTER, 0.8F, 1.1F, 0x372096, 0x895d1b);
	public static final RegistryObject<EntityType<Lich>> LICH = make(TFEntityNames.LICH, Lich::new, MobCategory.MONSTER, 1.1F, 2.1F, 0xaca489, 0x360472);
	public static final RegistryObject<EntityType<LichBolt>> LICH_BOLT = buildNoEgg(TFEntityNames.LICH_BOLT, makeCastedBuilder(LichBolt.class, LichBolt::new, 0.25F, 0.25F, 150, 2), false);
	public static final RegistryObject<EntityType<LichBomb>> LICH_BOMB = buildNoEgg(TFEntityNames.LICH_BOMB, makeCastedBuilder(LichBomb.class, LichBomb::new, 0.25F, 0.25F, 150, 3), false);
	public static final RegistryObject<EntityType<LichMinion>> LICH_MINION = make(TFEntityNames.LICH_MINION, LichMinion::new, MobCategory.MONSTER, 0.6F, 1.95F, 0, 0);
	public static final RegistryObject<EntityType<LowerGoblinKnight>> LOWER_GOBLIN_KNIGHT = make(TFEntityNames.LOWER_GOBLIN_KNIGHT, LowerGoblinKnight::new, MobCategory.MONSTER, 0.7F, 1.1F, 0x566055, 0xd3e7bc);
	public static final RegistryObject<EntityType<LoyalZombie>> LOYAL_ZOMBIE = make(TFEntityNames.LOYAL_ZOMBIE, LoyalZombie::new, MobCategory.MONSTER, 0.6F, 1.8F, 0, 0);
	public static final RegistryObject<EntityType<MazeSlime>> MAZE_SLIME = make(TFEntityNames.MAZE_SLIME, MazeSlime::new, MobCategory.MONSTER, 2.04F, 2.04F, 0xa3a3a3, 0x2a3b17);
	public static final RegistryObject<EntityType<Minoshroom>> MINOSHROOM = make(TFEntityNames.MINOSHROOM, Minoshroom::new, MobCategory.MONSTER, 1.49F, 2.5F, 0xa81012, 0xaa7d66);
	public static final RegistryObject<EntityType<Minotaur>> MINOTAUR = make(TFEntityNames.MINOTAUR, Minotaur::new, MobCategory.MONSTER, 0.6F, 2.1F, 0x3f3024, 0xaa7d66);
	public static final RegistryObject<EntityType<MistWolf>> MIST_WOLF = make(TFEntityNames.MIST_WOLF, MistWolf::new, MobCategory.MONSTER, 1.4F, 1.9F, 0x3a1411, 0xe2c88a);
	public static final RegistryObject<EntityType<MoonwormShot>> MOONWORM_SHOT = buildNoEgg(TFEntityNames.MOONWORM_SHOT, makeCastedBuilder(MoonwormShot.class, MoonwormShot::new, 0.25F, 0.25F, 150, 3), false);
	public static final RegistryObject<EntityType<MosquitoSwarm>> MOSQUITO_SWARM = make(TFEntityNames.MOSQUITO_SWARM, MosquitoSwarm::new, MobCategory.MONSTER, 0.7F, 1.9F, 0x080904, 0x2d2f21);
	public static final RegistryObject<EntityType<Naga>> NAGA = make(TFEntityNames.NAGA, Naga::new, MobCategory.MONSTER, 2.0F, 3.0F, true, 0xa4d316, 0x1b380b);
	public static final RegistryObject<EntityType<NatureBolt>> NATURE_BOLT = buildNoEgg(TFEntityNames.NATURE_BOLT, makeCastedBuilder(NatureBolt.class, NatureBolt::new, 0.25F, 0.25F, 150, 5), false);
	public static final RegistryObject<EntityType<MagicPainting>> MAGIC_PAINTING = buildNoEgg(TFEntityNames.MAGIC_PAINTING, makeCastedBuilder(MagicPainting.class, MagicPainting::new, 0.5F, 0.5F, 10, Integer.MAX_VALUE), false);
	public static final RegistryObject<EntityType<Penguin>> PENGUIN = make(TFEntityNames.PENGUIN, Penguin::new, MobCategory.CREATURE, 0.5F, 0.9F, 0x12151b, 0xf9edd2);
	public static final RegistryObject<EntityType<PinchBeetle>> PINCH_BEETLE = make(TFEntityNames.PINCH_BEETLE, PinchBeetle::new, MobCategory.MONSTER, 1.2F, 0.5F, 0xbc9327, 0x241609);
	public static final RegistryObject<EntityType<PlateauBoss>> PLATEAU_BOSS = make(TFEntityNames.PLATEAU_BOSS, PlateauBoss::new, MobCategory.MONSTER, 1F, 1F, true, 0, 0);
	public static final RegistryObject<EntityType<ProtectionBox>> PROTECTION_BOX = buildNoEgg(TFEntityNames.PROTECTION_BOX, makeCastedBuilder(ProtectionBox.class, ProtectionBox::new, 0, 0, 80, 3).disableSaving().disableSummon(), true);
	public static final RegistryObject<EntityType<QuestRam>> QUEST_RAM = make(TFEntityNames.QUEST_RAM, QuestRam::new, MobCategory.CREATURE, 1.25F, 2.9F, 0xfefeee, 0x33aadd);
	public static final RegistryObject<EntityType<Raven>> RAVEN = make(TFEntityNames.RAVEN, Raven::new, MobCategory.CREATURE, 0.3F, 0.5F, 0x000011, 0x222233);
	public static final RegistryObject<EntityType<Redcap>> REDCAP = make(TFEntityNames.REDCAP, Redcap::new, MobCategory.MONSTER, 0.9F, 1.4F, 0x3b3a6c, 0xab1e14);
	public static final RegistryObject<EntityType<RedcapSapper>> REDCAP_SAPPER = make(TFEntityNames.REDCAP_SAPPER, RedcapSapper::new, MobCategory.MONSTER, 0.9F, 1.4F, 0x575d21, 0xab1e14);
	public static final RegistryObject<EntityType<RisingZombie>> RISING_ZOMBIE = make(TFEntityNames.RISING_ZOMBIE, RisingZombie::new, MobCategory.MONSTER, 0.6F, 1.95F, 0, 0);
	public static final RegistryObject<EntityType<RovingCube>> ROVING_CUBE = make(TFEntityNames.ROVING_CUBE, RovingCube::new, MobCategory.MONSTER, 1.2F, 2.1F, 0, 0);
	public static final RegistryObject<EntityType<SeekerArrow>> SEEKER_ARROW = buildNoEgg(TFEntityNames.SEEKER_ARROW, makeCastedBuilder(SeekerArrow.class, SeekerArrow::new, 0.5F, 0.5F, 150, 1), false);
	public static final RegistryObject<EntityType<SkeletonDruid>> SKELETON_DRUID = make(TFEntityNames.SKELETON_DRUID, SkeletonDruid::new, MobCategory.MONSTER, 0.6F, 1.99F, 0xa3a3a3, 0x2a3b17);
	public static final RegistryObject<EntityType<SlideBlock>> SLIDER = buildNoEgg(TFEntityNames.SLIDER, makeCastedBuilder(SlideBlock.class, SlideBlock::new, 0.98F, 0.98F, 80, 1), false);
	public static final RegistryObject<EntityType<SlimeBeetle>> SLIME_BEETLE = make(TFEntityNames.SLIME_BEETLE, SlimeBeetle::new, MobCategory.MONSTER, 0.9F, 0.5F, 0x0c1606, 0x60a74c);
	public static final RegistryObject<EntityType<SlimeProjectile>> SLIME_BLOB = buildNoEgg(TFEntityNames.SLIME_BLOB, makeCastedBuilder(SlimeProjectile.class, SlimeProjectile::new, 0.25F, 0.25F, 150, 3), false);
	public static final RegistryObject<EntityType<SnowGuardian>> SNOW_GUARDIAN = make(TFEntityNames.SNOW_GUARDIAN, SnowGuardian::new, MobCategory.MONSTER, 0.6F, 1.8F, 0xd3e7bc, 0xfefefe);
	public static final RegistryObject<EntityType<SnowQueen>> SNOW_QUEEN = make(TFEntityNames.SNOW_QUEEN, SnowQueen::new, MobCategory.MONSTER, 0.7F, 2.2F, 0xb1b2d4, 0x87006e);
	public static final RegistryObject<EntityType<Squirrel>> SQUIRREL = make(TFEntityNames.SQUIRREL, Squirrel::new, MobCategory.CREATURE, 0.3F, 0.5F, 0x904f12, 0xeeeeee);
	public static final RegistryObject<EntityType<StableIceCore>> STABLE_ICE_CORE = make(TFEntityNames.STABLE_ICE_CORE, StableIceCore::new, MobCategory.MONSTER, 0.8F, 1.8F, 0xa1bff3, 0x7000f8);
	public static final RegistryObject<EntityType<SwarmSpider>> SWARM_SPIDER = make(TFEntityNames.SWARM_SPIDER, SwarmSpider::new, MobCategory.MONSTER, 0.8F, 0.4F, 0x32022e, 0x17251e);
	public static final RegistryObject<EntityType<ThrownBlock>> THROWN_BLOCK = buildNoEgg(TFEntityNames.THROWN_BLOCK, makeCastedBuilder(ThrownBlock.class, ThrownBlock::new, 1.0F, 1.0F, 80, 2), true);
	public static final RegistryObject<EntityType<ThrownWep>> THROWN_WEP = make(TFEntityNames.THROWN_WEP, ThrownWep::new, MobCategory.MISC, 0.5F, 0.5F, 0, 0);
	public static final RegistryObject<EntityType<TinyBird>> TINY_BIRD = make(TFEntityNames.TINY_BIRD, TinyBird::new, MobCategory.CREATURE, 0.3F, 0.3F, 0x33aadd, 0x1188ee);
	public static final RegistryObject<EntityType<TomeBolt>> TOME_BOLT = buildNoEgg(TFEntityNames.TOME_BOLT, makeCastedBuilder(TomeBolt.class, TomeBolt::new, 0.25F, 0.25F, 150, 5), false);
	public static final RegistryObject<EntityType<TowerwoodBorer>> TOWERWOOD_BORER = make(TFEntityNames.TOWERWOOD_BORER, TowerwoodBorer::new, MobCategory.MONSTER, 0.4F, 0.3F, 0x5d2b21, 0xaca03a);
	public static final RegistryObject<EntityType<Troll>> TROLL = make(TFEntityNames.TROLL, Troll::new, MobCategory.MONSTER, 1.4F, 2.4F, 0x9ea98f, 0xb0948e);
	public static final RegistryObject<EntityType<TwilightWandBolt>> WAND_BOLT = buildNoEgg(TFEntityNames.WAND_BOLT, makeCastedBuilder(TwilightWandBolt.class, TwilightWandBolt::new, 0.25F, 0.25F, 150, 5), false);
	public static final RegistryObject<EntityType<UnstableIceCore>> UNSTABLE_ICE_CORE = make(TFEntityNames.UNSTABLE_ICE_CORE, UnstableIceCore::new, MobCategory.MONSTER, 0.8F, 1.8F, 0x9aacf5, 0x9b0fa5);
	public static final RegistryObject<EntityType<UpperGoblinKnight>> UPPER_GOBLIN_KNIGHT = make(TFEntityNames.UPPER_GOBLIN_KNIGHT, UpperGoblinKnight::new, MobCategory.MONSTER, 1.1F, 1.3F, 0, 0);
	public static final RegistryObject<EntityType<UrGhast>> UR_GHAST = make(TFEntityNames.UR_GHAST, UrGhast::new, MobCategory.MONSTER, 14.0F, 18.0F, true, 0xbcbcbc, 0xb77878);
	public static final RegistryObject<EntityType<WinterWolf>> WINTER_WOLF = make(TFEntityNames.WINTER_WOLF, WinterWolf::new, MobCategory.MONSTER, 1.4F, 1.9F, 0xdfe3e5, 0xb2bcca);
	public static final RegistryObject<EntityType<Wraith>> WRAITH = make(TFEntityNames.WRAITH, Wraith::new, MobCategory.MONSTER, 0.6F, 1.8F, true, 0x505050, 0x838383);
	public static final RegistryObject<EntityType<Yeti>> YETI = make(TFEntityNames.YETI, Yeti::new, MobCategory.MONSTER, 1.4F, 2.4F, 0xdedede, 0x4675bb);

	private static <E extends Entity> RegistryObject<EntityType<E>> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, int primary, int secondary) {
		return make(id, factory, classification, width, height, false, primary, secondary);
	}

	private static <E extends Entity> RegistryObject<EntityType<E>> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, boolean fireproof, int primary, int secondary) {
		return build(id, makeBuilder(factory, classification, width, height, 80, 3), fireproof, primary, secondary);
	}

	private static <E extends Entity> RegistryObject<EntityType<E>> buildNoEgg(ResourceLocation id, FabricEntityTypeBuilder<E> builder, boolean fireproof) {
		if (fireproof) builder.fireImmune();
		return ENTITIES.register(id.getPath(), builder::build);
	}

	@SuppressWarnings("unchecked")
	private static <E extends Entity> RegistryObject<EntityType<E>> build(ResourceLocation id, FabricEntityTypeBuilder<E> builder, boolean fireproof, int primary, int secondary) {
		if (fireproof) builder.fireImmune();
		RegistryObject<EntityType<E>> ret = ENTITIES.register(id.getPath(), () -> builder.build());
		if (primary != 0 && secondary != 0) {
			SPAWN_EGGS.register(id.getPath() + "_spawn_egg", () -> new LazySpawnEggItem(() -> (EntityType<? extends Mob>) ret.get(), primary, secondary, new Item.Properties()));
		}
		return ret;
	}

	private static <E extends Entity> FabricEntityTypeBuilder<E> makeCastedBuilder(@SuppressWarnings("unused") Class<E> cast, EntityType.EntityFactory<E> factory, float width, float height, int range, int interval) {
		return makeBuilder(factory, MobCategory.MISC, width, height, range, interval);
	}

	private static <E extends Entity> FabricEntityTypeBuilder<E> makeBuilder(EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, int range, int interval) {
		return FabricEntityTypeBuilder.create(classification, factory).
				dimensions(EntityDimensions.fixed(width, height)).
				trackRangeChunks(range).
				trackedUpdateRate(interval).
				forceTrackedVelocityUpdates(true);
	}

	public static void registerSpawnPlacements() {
		SpawnPlacements.register(BOAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(BIGHORN_SHEEP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(DEER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(REDCAP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(SKELETON_DRUID.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SkeletonDruid::checkDruidSpawnRules);
		SpawnPlacements.register(WRAITH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Wraith::checkMonsterSpawnRules);
		SpawnPlacements.register(HOSTILE_WOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HostileWolf::checkWolfSpawnRules);
		SpawnPlacements.register(HYDRA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(LICH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(PENGUIN.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Penguin::canSpawn);
		SpawnPlacements.register(LICH_MINION.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(LOYAL_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(TINY_BIRD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(SQUIRREL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(DWARF_RABBIT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(RAVEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(QUEST_RAM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
		SpawnPlacements.register(KOBOLD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MOSQUITO_SWARM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(DEATH_TOME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MINOTAUR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MINOSHROOM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(FIRE_BEETLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(SLIME_BEETLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(PINCH_BEETLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MIST_WOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(CARMINITE_GHASTLING.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastling::canSpawnHere);
		SpawnPlacements.register(CARMINITE_GOLEM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(TOWERWOOD_BORER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(CARMINITE_GHASTGUARD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastguard::ghastSpawnHandler);
		SpawnPlacements.register(UR_GHAST.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CarminiteGhastguard::ghastSpawnHandler);
		SpawnPlacements.register(BLOCKCHAIN_GOBLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(UPPER_GOBLIN_KNIGHT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(LOWER_GOBLIN_KNIGHT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(HELMET_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(KNIGHT_PHANTOM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
		SpawnPlacements.register(NAGA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(SWARM_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SwarmSpider::getCanSpawnHere);
		SpawnPlacements.register(KING_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(CARMINITE_BROODLING.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(HEDGE_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HedgeSpider::canSpawn);
		SpawnPlacements.register(REDCAP_SAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(MAZE_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MazeSlime::getCanSpawnHere);
		SpawnPlacements.register(YETI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Yeti::yetiSnowyForestSpawnHandler);
		SpawnPlacements.register(ALPHA_YETI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(WINTER_WOLF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WinterWolf::canSpawnHere);
		SpawnPlacements.register(SNOW_GUARDIAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(STABLE_ICE_CORE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(UNSTABLE_ICE_CORE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(SNOW_QUEEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(TROLL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(GIANT_MINER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantMiner::canSpawn);
		SpawnPlacements.register(ARMORED_GIANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantMiner::canSpawn);
		SpawnPlacements.register(ICE_CRYSTAL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(HARBINGER_CUBE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(ADHERENT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(ROVING_CUBE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(RISING_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
	}

	public static void addEntityAttributes() {
		FabricDefaultAttributeRegistry.register(BOAR.get(), Boar.registerAttributes());
		FabricDefaultAttributeRegistry.register(BIGHORN_SHEEP.get(), Sheep.createAttributes());
		FabricDefaultAttributeRegistry.register(DEER.get(), Deer.registerAttributes());
		FabricDefaultAttributeRegistry.register(REDCAP.get(), Redcap.registerAttributes());
		FabricDefaultAttributeRegistry.register(SWARM_SPIDER.get(), SwarmSpider.registerAttributes());
		FabricDefaultAttributeRegistry.register(NAGA.get(), Naga.registerAttributes());
		FabricDefaultAttributeRegistry.register(SKELETON_DRUID.get(), AbstractSkeleton.createAttributes());
		FabricDefaultAttributeRegistry.register(HOSTILE_WOLF.get(), HostileWolf.registerAttributes());
		FabricDefaultAttributeRegistry.register(WRAITH.get(), Wraith.registerAttributes());
		FabricDefaultAttributeRegistry.register(HEDGE_SPIDER.get(), Spider.createAttributes());
		FabricDefaultAttributeRegistry.register(HYDRA.get(), Hydra.registerAttributes());
		FabricDefaultAttributeRegistry.register(LICH.get(), Lich.registerAttributes());
		FabricDefaultAttributeRegistry.register(PENGUIN.get(), Penguin.registerAttributes());
		FabricDefaultAttributeRegistry.register(LICH_MINION.get(), Zombie.createAttributes());
		FabricDefaultAttributeRegistry.register(LOYAL_ZOMBIE.get(), LoyalZombie.registerAttributes());
		FabricDefaultAttributeRegistry.register(TINY_BIRD.get(), TinyBird.registerAttributes());
		FabricDefaultAttributeRegistry.register(SQUIRREL.get(), Squirrel.registerAttributes());
		FabricDefaultAttributeRegistry.register(DWARF_RABBIT.get(), DwarfRabbit.registerAttributes());
		FabricDefaultAttributeRegistry.register(RAVEN.get(), Raven.registerAttributes());
		FabricDefaultAttributeRegistry.register(QUEST_RAM.get(), QuestRam.registerAttributes());
		FabricDefaultAttributeRegistry.register(KOBOLD.get(), Kobold.registerAttributes());
		FabricDefaultAttributeRegistry.register(MOSQUITO_SWARM.get(), MosquitoSwarm.registerAttributes());
		FabricDefaultAttributeRegistry.register(DEATH_TOME.get(), DeathTome.registerAttributes());
		FabricDefaultAttributeRegistry.register(MINOTAUR.get(), Minotaur.registerAttributes());
		FabricDefaultAttributeRegistry.register(MINOSHROOM.get(), Minoshroom.registerAttributes());
		FabricDefaultAttributeRegistry.register(FIRE_BEETLE.get(), FireBeetle.registerAttributes());
		FabricDefaultAttributeRegistry.register(SLIME_BEETLE.get(), SlimeBeetle.registerAttributes());
		FabricDefaultAttributeRegistry.register(PINCH_BEETLE.get(), PinchBeetle.registerAttributes());
		FabricDefaultAttributeRegistry.register(MAZE_SLIME.get(), MazeSlime.registerAttributes());
		FabricDefaultAttributeRegistry.register(REDCAP_SAPPER.get(), RedcapSapper.registerAttributes());
		FabricDefaultAttributeRegistry.register(MIST_WOLF.get(), MistWolf.registerAttributes());
		FabricDefaultAttributeRegistry.register(KING_SPIDER.get(), KingSpider.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_GHASTLING.get(), CarminiteGhastling.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_GHASTGUARD.get(), CarminiteGhastguard.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_GOLEM.get(), CarminiteGolem.registerAttributes());
		FabricDefaultAttributeRegistry.register(TOWERWOOD_BORER.get(), TowerwoodBorer.registerAttributes());
		FabricDefaultAttributeRegistry.register(CARMINITE_BROODLING.get(), TowerBroodling.registerAttributes());
		FabricDefaultAttributeRegistry.register(UR_GHAST.get(), UrGhast.registerAttributes());
		FabricDefaultAttributeRegistry.register(BLOCKCHAIN_GOBLIN.get(), BlockChainGoblin.registerAttributes());
		FabricDefaultAttributeRegistry.register(UPPER_GOBLIN_KNIGHT.get(), UpperGoblinKnight.registerAttributes());
		FabricDefaultAttributeRegistry.register(LOWER_GOBLIN_KNIGHT.get(), LowerGoblinKnight.registerAttributes());
		FabricDefaultAttributeRegistry.register(HELMET_CRAB.get(), HelmetCrab.registerAttributes());
		FabricDefaultAttributeRegistry.register(KNIGHT_PHANTOM.get(), KnightPhantom.registerAttributes());
		FabricDefaultAttributeRegistry.register(YETI.get(), Yeti.registerAttributes());
		FabricDefaultAttributeRegistry.register(ALPHA_YETI.get(), AlphaYeti.registerAttributes());
		FabricDefaultAttributeRegistry.register(WINTER_WOLF.get(), WinterWolf.registerAttributes());
		FabricDefaultAttributeRegistry.register(SNOW_GUARDIAN.get(), SnowGuardian.registerAttributes());
		FabricDefaultAttributeRegistry.register(STABLE_ICE_CORE.get(), StableIceCore.registerAttributes());
		FabricDefaultAttributeRegistry.register(UNSTABLE_ICE_CORE.get(), UnstableIceCore.registerAttributes());
		FabricDefaultAttributeRegistry.register(SNOW_QUEEN.get(), SnowQueen.registerAttributes());
		FabricDefaultAttributeRegistry.register(TROLL.get(), Troll.registerAttributes());
		FabricDefaultAttributeRegistry.register(GIANT_MINER.get(), GiantMiner.registerAttributes());
		FabricDefaultAttributeRegistry.register(ARMORED_GIANT.get(), GiantMiner.registerAttributes());
		FabricDefaultAttributeRegistry.register(ICE_CRYSTAL.get(), IceCrystal.registerAttributes());
		FabricDefaultAttributeRegistry.register(HARBINGER_CUBE.get(), HarbingerCube.registerAttributes());
		FabricDefaultAttributeRegistry.register(ADHERENT.get(), Adherent.registerAttributes());
		FabricDefaultAttributeRegistry.register(ROVING_CUBE.get(), RovingCube.registerAttributes());
		FabricDefaultAttributeRegistry.register(PLATEAU_BOSS.get(), PlateauBoss.registerAttributes());

		//event.put(BOGGARD.get(), Boggard.registerAttributes().create());
		FabricDefaultAttributeRegistry.register(RISING_ZOMBIE.get(), Zombie.createAttributes());
	}

	public static void init() {
		registerSpawnPlacements();
		addEntityAttributes();
	}
}
