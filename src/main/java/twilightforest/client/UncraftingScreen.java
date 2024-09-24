package twilightforest.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import twilightforest.TFConfig;
import twilightforest.TwilightForestMod;
import twilightforest.data.tags.ItemTagGenerator;
import twilightforest.inventory.UncraftingMenu;
import twilightforest.network.TFPacketHandler;
import twilightforest.network.UncraftingGuiPacket;

public class UncraftingScreen extends AbstractContainerScreen<UncraftingMenu> {

	private static final ResourceLocation TEXTURE = TwilightForestMod.getGuiTexture("guigoblintinkering.png");

	public UncraftingScreen(UncraftingMenu container, Inventory player, Component name) {
		super(container, player, name);
	}

	@Override
	protected void init() {
		super.init();

		this.addRenderableWidget(new CycleButton(this.leftPos + 40, this.topPos + 22, true, button -> {
			TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(0));
			this.menu.unrecipeInCycle++;
			this.menu.slotsChanged(this.menu.tinkerInput);
		}));
		this.addRenderableWidget(new CycleButton(this.leftPos + 40, this.topPos + 55, false, button -> {
			TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(1));
			this.menu.unrecipeInCycle--;
			this.menu.slotsChanged(this.menu.tinkerInput);
		}));

		//this.buttonList.add(new ModeButton(uiLeft + 7, guiTop + 57));

		this.addRenderableWidget(new CycleButtonMini(this.leftPos + 27, this.topPos + 56, true, button -> {
			TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(2));
			this.menu.ingredientsInCycle++;
			this.menu.slotsChanged(this.menu.tinkerInput);
		}));
		this.addRenderableWidget(new CycleButtonMini(this.leftPos + 27, this.topPos + 63, false, button -> {
			TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(3));
			this.menu.ingredientsInCycle--;
			this.menu.slotsChanged(this.menu.tinkerInput);
		}));

		//this.buttonList.add(new RefreshButton(uiLeft + 26, guiTop + 57));

		this.addRenderableWidget(new CycleButton(this.leftPos + 121, this.topPos + 22, true, button -> {
			TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(4));
			this.menu.recipeInCycle++;
			this.menu.slotsChanged(this.menu.assemblyMatrix);
		}));
		this.addRenderableWidget(new CycleButton(this.leftPos + 121, this.topPos + 55, false, button -> {
			TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(5));
			this.menu.recipeInCycle--;
			this.menu.slotsChanged(this.menu.assemblyMatrix);
		}));
	}

	@Override
	public boolean mouseScrolled(double x, double y, double direction) {
		boolean scrolled = super.mouseScrolled(x, y, direction);

		//ingredient buttons
		if (x > this.leftPos + 27 && x < this.leftPos + 33 && y > this.topPos + 56 && y < this.topPos + 69) {
			if (direction > 0) {
				TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(2));
				this.menu.ingredientsInCycle++;
			} else {
				TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(3));
				this.menu.ingredientsInCycle--;
			}
			this.menu.slotsChanged(this.menu.tinkerInput);
		}

		//uncrafting recipe buttons
		if (x > this.leftPos + 40 && x < this.leftPos + 54 && y > this.topPos + 22 && y < this.topPos + 64) {
			if (direction > 0) {
				TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(0));
				this.menu.unrecipeInCycle++;
			} else {
				TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(1));
				this.menu.unrecipeInCycle--;
			}
			this.menu.slotsChanged(this.menu.tinkerInput);
		}

		//recrafting recipe buttons
		if (x > this.leftPos + 121 && x < this.leftPos + 135 && y > this.topPos + 22 && y < this.topPos + 64) {
			if (direction > 0) {
				TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(4));
				this.menu.recipeInCycle++;
			} else {
				TFPacketHandler.CHANNEL.sendToServer(new UncraftingGuiPacket(5));
				this.menu.recipeInCycle--;
			}
			this.menu.slotsChanged(this.menu.assemblyMatrix);
		}

		return scrolled;
	}

	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(graphics);
		super.render(graphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(graphics, mouseX, mouseY); //renderHoveredToolTip
	}

	@Override
	protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
		graphics.drawString(this.font, this.title, 6, 6, 4210752, false);
		if (TFConfig.COMMON_CONFIG.UNCRAFTING_STUFFS.disableUncraftingOnly.get()) {
			graphics.drawString(this.font, Component.translatable("container.twilightforest.uncrafting_table.uncrafting_disabled").withStyle(ChatFormatting.DARK_RED), 6, this.imageHeight - 96 + 2, 4210752, false);
		} else {
			graphics.drawString(this.font, I18n.get("container.inventory"), 7, this.imageHeight - 96 + 2, 4210752, false);
		}
	}

	@Override
	protected void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
		int frameX = (this.width - this.imageWidth) / 2;
		int frameY = (this.height - this.imageHeight) / 2;
		graphics.blit(TEXTURE, frameX, frameY, 0, 0, this.imageWidth, this.imageHeight);

		UncraftingMenu tfContainer = this.menu;

		// show uncrafting ingredients as background
		graphics.pose().pushPose();
		graphics.pose().translate(this.leftPos, this.topPos, 0);

		for (int i = 0; i < 9; i++) {
			Slot uncrafting = tfContainer.getSlot(2 + i);
			Slot assembly = tfContainer.getSlot(11 + i);

			if (uncrafting.hasItem()) {
				this.drawSlotAsBackground(graphics, uncrafting, assembly);
			}
		}
		graphics.pose().popPose();

		int costVal = tfContainer.getUncraftingCost();
		if (costVal > 0) {
			int color;
			String cost = "" + costVal;
			if (this.minecraft.player.experienceLevel < costVal && !this.minecraft.player.getAbilities().instabuild) {
				color = 0xA00000;
			} else {
				color = 0x80FF20;
			}
			graphics.drawString(this.font, cost, frameX + 48 - this.font.width(cost), frameY + 38, color);
		}

		costVal = tfContainer.getRecraftingCost();
		if (costVal > 0) {
			int color;
			String cost = "" + costVal;
			if (this.minecraft.player.experienceLevel < costVal && !this.minecraft.player.getAbilities().instabuild) {
				color = 0xA00000;
			} else {
				color = 0x80FF20;
			}
			graphics.drawString(this.font, cost, frameX + 130 - this.font.width(cost), frameY + 38, color);
		}
	}

	private void drawSlotAsBackground(GuiGraphics graphics, Slot backgroundSlot, Slot appearSlot) {

		int screenX = appearSlot.x;
		int screenY = appearSlot.y;
		ItemStack itemStackToRender = backgroundSlot.getItem();

		graphics.renderFakeItem(itemStackToRender, screenX, screenY);

		boolean itemBroken = UncraftingMenu.isMarked(itemStackToRender);

		// draw 50% gray rectangle over the item
		RenderSystem.disableDepthTest();
		graphics.pose().pushPose();
		graphics.pose().translate(0.0D, 0.0D, 200.0D);
		graphics.fill(appearSlot.x, appearSlot.y, appearSlot.x + 16, appearSlot.y + 16, itemBroken ? 0x80FF8b8b : 0x9f8b8b8b);
		graphics.pose().popPose();
		RenderSystem.enableDepthTest();
	}

	@Override
	protected void renderTooltip(GuiGraphics graphics, int pX, int pY) {
		UncraftingMenu container = this.menu;

		for (int i = 0; i < 9; i++) {
			if (container.getCarried().isEmpty() && container.slots.get(2 + i).hasItem() && this.hoveredSlot == container.slots.get(11 + i) && !container.slots.get(11 + i).hasItem()) {
				graphics.renderTooltip(this.font, container.slots.get(2 + i).getItem(), pX, pY);
			}
		}

		//check if we're hovering over a banned uncraftable item
		if (container.slots.get(0).hasItem() && container.slots.get(0).getItem().is(ItemTagGenerator.BANNED_UNCRAFTABLES) && container.slots.get(0).equals(hoveredSlot)) {
			graphics.renderTooltip(this.font, Component.translatable("container.twilightforest.uncrafting_table.disabled_item").withStyle(ChatFormatting.RED), pX, pY);
		} else {
			super.renderTooltip(graphics, pX, pY);
		}
	}

	private static class CycleButton extends Button {
		private final boolean up;

		CycleButton(int x, int y, boolean up, OnPress onClick) {
			super(x, y, 14, 9, Component.empty(), onClick, message -> Component.empty());
			this.up = up;
		}

		@Override
		public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
			if (this.visible) {
				this.isHovered = mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.width && mouseY < this.getY() + this.height;

				int textureX = 176;
				int textureY = 0;

				if (this.isHovered) textureX += this.width;

				// what's up
				if (!this.up) textureY += this.height;

				graphics.blit(TEXTURE, this.getX(), this.getY(), textureX, textureY, this.width, this.height);
			}
		}
	}

	private static class CycleButtonMini extends Button {
		private final boolean up;

		CycleButtonMini(int x, int y, boolean up, OnPress onClick) {
			super(x, y, 8, 6, Component.empty(), onClick, message -> Component.empty());
			this.up = up;
		}

		@Override
		public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
			if (this.visible) {
				this.isHovered = mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.width && mouseY < this.getY() + this.height;

				int textureX = 176;
				int textureY = 41;

				if (this.isHovered) textureX += this.width;

				// what's up
				if (!this.up) textureY += this.height;

				graphics.blit(TEXTURE, this.getX(), this.getY(), textureX, textureY, this.width, this.height);
			}
		}
	}
}
