// Date: 2/5/2012 10:11:18 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import twilightforest.entity.boss.Hydra;

public class HydraModel extends HierarchicalModel<Hydra> {
	//fields
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart leg1;
	private final ModelPart leg2;

	@Nullable
	private Hydra hydra;

	public HydraModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.tail = root.getChild("tail_1");
		this.leg1 = root.getChild("leg_1");
		this.leg2 = root.getChild("leg_2");
	}

	public static LayerDefinition create() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition partRoot = mesh.getRoot();

		partRoot.addOrReplaceChild("body", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-48F, 0F, 0F, 96, 96, 40),
				PartPose.offsetAndRotation(0F, -12F, 0F, 1.22173F, 0F, 0F));

		partRoot.addOrReplaceChild("leg_1", CubeListBuilder.create()
						.texOffs(0, 136)
						.addBox(-16F, 0F, -16F, 32, 48, 32)
						.texOffs(184, 200)
						.addBox(-20F, 40F, -20F, 8, 8, 8)
						.texOffs(184, 200)
						.addBox(-4F, 40F, -22F, 8, 8, 8)
						.texOffs(184, 200)
						.addBox(12F, 40F, -20F, 8, 8, 8),
				PartPose.offset(48F, -24F, 0F));

		partRoot.addOrReplaceChild("leg_2", CubeListBuilder.create().mirror()
						.texOffs(0, 136)
						.addBox(-16F, 0F, -16F, 32, 48, 32)
						.texOffs(184, 200)
						.addBox(-20F, 40F, -20F, 8, 8, 8)
						.texOffs(184, 200)
						.addBox(-4F, 40F, -22F, 8, 8, 8)
						.texOffs(184, 200)
						.addBox(12F, 40F, -20F, 8, 8, 8),
				PartPose.offset(-48F, -24F, 0F));

		var tail1 = partRoot.addOrReplaceChild("tail_1", CubeListBuilder.create()
						.texOffs(128, 136)
						.addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200)
						.addBox(-2F, -28F, -11F, 4, 24, 24),
				PartPose.offset(0F, 6F, 108F));

		var tail2 = tail1.addOrReplaceChild("tail_2", CubeListBuilder.create()
						.texOffs(128, 136)
						.addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200)
						.addBox(-2F, -28F, -11F, 4, 24, 24),
				PartPose.offset(0F, 0F, 32F));

		var tail3 = tail2.addOrReplaceChild("tail_3", CubeListBuilder.create()
						.texOffs(128, 136)
						.addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200)
						.addBox(-2F, -28F, -11F, 4, 24, 24),
				PartPose.offset(0F, 0F, 32F));

		tail3.addOrReplaceChild("tail_4", CubeListBuilder.create()
						.texOffs(128, 136)
						.addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200)
						.addBox(-2F, -28F, -11F, 4, 24, 24),
				PartPose.offset(0F, 0F, 32F));

		var head1 = partRoot.addOrReplaceChild("head_1", CubeListBuilder.create()
						.texOffs(272, 0)
						.addBox(-16F, -14F, -32F, 32, 24, 32)
						.texOffs(272, 56)
						.addBox(-15F, -2F, -56F, 30, 12, 24)
						.texOffs(128, 200)
						.addBox(-2F, -30F, -12F, 4, 24, 24),
				PartPose.offset(-74F, -100F, -32F));

		head1.addOrReplaceChild("jaw_1", CubeListBuilder.create()
						.texOffs(272, 92)
						.addBox(-15F, 0F, -48F, 30, 8, 48),
				PartPose.offset(0F, 10F, -4F));

		head1.addOrReplaceChild("frill_1", CubeListBuilder.create()
						.texOffs(272, 200)
						.addBox(-24F, -40.0F, 0F, 48, 48, 4),
				PartPose.offsetAndRotation(0F, 0F, -10F, -0.5235988F, 0F, 0F));

		var neck1a = partRoot.addOrReplaceChild("neck_1a", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(-42F, -48F, 0F));

		var neck1b = neck1a.addOrReplaceChild("neck_1b", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(-16F, -16F, -16F));

		neck1b.addOrReplaceChild("neck_1c", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(-16F, -16F, -16F));

		var head2 = partRoot.addOrReplaceChild("head_2", CubeListBuilder.create()
						.texOffs(272, 0)
						.addBox(-16F, -14F, -32F, 32, 24, 32)
						.texOffs(272, 56)
						.addBox(-15F, -2F, -56F, 30, 12, 24)
						.texOffs(128, 200)
						.addBox(-2F, -30F, -12F, 4, 24, 24),
				PartPose.offset(0F, -116F, -32F));

		head2.addOrReplaceChild("jaw_2", CubeListBuilder.create()
						.texOffs(272, 92)
						.addBox(-15F, 0F, -48F, 30, 8, 48),
				PartPose.offset(0F, 10F, -4F));

		head2.addOrReplaceChild("frill_2", CubeListBuilder.create()
						.texOffs(272, 200)
						.addBox(-24F, -40.0F, 0F, 48, 48, 4),
				PartPose.offsetAndRotation(0F, 0F, -10F, -0.5235988F, 0F, 0F));

		var neck2a = partRoot.addOrReplaceChild("neck_2a", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(0F, -48F, 0F));

		var neck2b = neck2a.addOrReplaceChild("neck_2b", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(-0F, -24F, -16F));

		neck2b.addOrReplaceChild("neck_2c", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(0F, -24F, -16F));

		var head3 = partRoot.addOrReplaceChild("head_3", CubeListBuilder.create()
						.texOffs(272, 0)
						.addBox(-16F, -14F, -32F, 32, 24, 32)
						.texOffs(272, 56)
						.addBox(-15F, -2F, -56F, 30, 12, 24)
						.texOffs(128, 200)
						.addBox(-2F, -30F, -12F, 4, 24, 24),
				PartPose.offset(74F, -100F, -32F));

		head3.addOrReplaceChild("jaw_3", CubeListBuilder.create()
						.texOffs(272, 92)
						.addBox(-15F, 0F, -48F, 30, 8, 48),
				PartPose.offset(0F, 10F, -4F));

		head3.addOrReplaceChild("frill_3", CubeListBuilder.create()
						.texOffs(272, 200)
						.addBox(-24F, -40.0F, 0F, 48, 48, 4),
				PartPose.offsetAndRotation(0F, 0F, -10F, -0.5235988F, 0F, 0F));

		var neck3a = partRoot.addOrReplaceChild("neck_3a", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(42F, -48F, 0F));

		var neck3b = neck3a.addOrReplaceChild("neck_3b", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(16F, -16F, -16F));

		neck3b.addOrReplaceChild("neck_3c", CubeListBuilder.create()
						.texOffs(128, 136).addBox(-16F, -16F, -16F, 32, 32, 32)
						.texOffs(128, 200).addBox(-2F, -24F, 0F, 4, 24, 24),
				PartPose.offset(16F, -16F, -16F));

		return LayerDefinition.create(mesh, 512, 256);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void renderToBuffer(PoseStack stack, VertexConsumer consumer, int light, int overlay, float red, float green, float blue, float alpha) {
		if (this.hydra != null && this.hydra.renderFakeHeads) {
			super.renderToBuffer(stack, consumer, light, overlay, red, green, blue, alpha);
		} else {
			this.leg1.render(stack, consumer, light, overlay, red, green, blue, alpha);
			this.leg2.render(stack, consumer, light, overlay, red, green, blue, alpha);
			this.body.render(stack, consumer, light, overlay, red, green, blue, alpha);
			this.tail.render(stack, consumer, light, overlay, red, green, blue, alpha);
		}
	}

	@Override
	public void setupAnim(Hydra entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.hydra = entity;

		this.leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;

		this.leg1.yRot = 0.0F;
		this.leg2.yRot = 0.0F;
	}
}
