// Date: 11/5/2012 7:35:56 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package twilightforest.client.model.entity;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import twilightforest.entity.monster.FireBeetle;

public class FireBeetleModel extends HierarchicalModel<FireBeetle> {
	final ModelPart root;
	final ModelPart head;
	final ModelPart leg6;
	final ModelPart leg4;
	final ModelPart leg2;
	final ModelPart leg5;
	final ModelPart leg3;
	final ModelPart leg1;

	public FireBeetleModel(ModelPart root) {
		this.root = root;

		this.head = root.getChild("head");

		this.leg1 = root.getChild("leg_1");
		this.leg2 = root.getChild("leg_2");
		this.leg3 = root.getChild("leg_3");
		this.leg4 = root.getChild("leg_4");
		this.leg5 = root.getChild("leg_5");
		this.leg6 = root.getChild("leg_6");
	}

	public static LayerDefinition create() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition partRoot = mesh.getRoot();

		var head = partRoot.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-4F, -4F, -6F, 8, 6, 6),
				PartPose.offset(0F, 19F, -5F));

		head.addOrReplaceChild("right_antenna", CubeListBuilder.create()
						.texOffs(42, 4)
						.addBox(0F, -0.5F, -0.5F, 10, 1, 1),
				PartPose.offsetAndRotation(1F, -3F, -5F, 0F, 1.047198F, -0.296706F));

		head.addOrReplaceChild("left_antenna", CubeListBuilder.create()
						.texOffs(42, 4)
						.addBox(0F, -0.5F, -0.5F, 10, 1, 1),
				PartPose.offsetAndRotation(-1F, -3F, -5F, 0F, 2.094395F, 0.296706F));

		head.addOrReplaceChild("right_eye", CubeListBuilder.create()
						.texOffs(15, 12)
						.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3),
				PartPose.offset(-3F, -2F, -5F));

		head.addOrReplaceChild("left_eye", CubeListBuilder.create()
						.texOffs(15, 12)
						.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3),
				PartPose.offset(3F, -2F, -5F));

		var jaw1a = head.addOrReplaceChild("jaw_1a", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(0F, 0F, -2F, 1, 1, 2),
				PartPose.offsetAndRotation(-3F, 0F, -6F, 0.3490659F, 0F, 0F));

		jaw1a.addOrReplaceChild("jaw_1b", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(0F, 0F, 0F, 1, 1, 2),
				PartPose.offsetAndRotation(0F, 0F, -2F, 0F, 1.570796F, 0F));

		var jaw1b = head.addOrReplaceChild("jaw_2a", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-1F, 0F, -2F, 1, 1, 2),
				PartPose.offsetAndRotation(3F, 0F, -6F, 0.3490659F, 0F, 0F));

		jaw1b.addOrReplaceChild("jaw_2b", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(0F, 0F, -2F, 1, 1, 2),
				PartPose.offsetAndRotation(0F, 0F, -2F, 0F, 1.570796F, 0F));

		partRoot.addOrReplaceChild("thorax", CubeListBuilder.create()
						.texOffs(0, 22)
						.addBox(-4.5F, -4F, 0F, 9, 8, 2),
				PartPose.offset(0F, 18F, -4.5F));

		partRoot.addOrReplaceChild("connector_1", CubeListBuilder.create()
						.texOffs(0, 12)
						.addBox(-3F, -3F, 0F, 6, 6, 1),
				PartPose.offset(0F, 18F, -3F));

		partRoot.addOrReplaceChild("connector_2", CubeListBuilder.create()
						.texOffs(0, 12)
						.addBox(-3F, -3F, -1F, 6, 6, 1),
				PartPose.offset(0F, 18F, -4F));

		partRoot.addOrReplaceChild("rear", CubeListBuilder.create()
						.texOffs(22, 9)
						.addBox(-6F, -9F, -4F, 12, 14, 9),
				PartPose.offsetAndRotation(0F, 18F, 7F, 1.570796F, 0F, 0F));

		partRoot.addOrReplaceChild("leg_1", CubeListBuilder.create().mirror()
						.texOffs(40, 0)
						.addBox(-9F, -1F, -1F, 10, 2, 2),
				PartPose.offsetAndRotation(-4F, 21F, 4F, 0F, 0.6981317F, -0.3490659F));

		partRoot.addOrReplaceChild("leg_2", CubeListBuilder.create()
						.texOffs(40, 0)
						.addBox(-1F, -1F, -1F, 10, 2, 2),
				PartPose.offsetAndRotation(4F, 21F, 4F, 0F, -0.6981317F, 0.3490659F));

		partRoot.addOrReplaceChild("leg_3", CubeListBuilder.create().mirror()
						.texOffs(40, 0)
						.addBox(-9F, -1F, -1F, 10, 2, 2),
				PartPose.offsetAndRotation(-4F, 21F, -1F, 0F, 0.2792527F, -0.3490659F));

		partRoot.addOrReplaceChild("leg_4", CubeListBuilder.create()
						.texOffs(40, 0)
						.addBox(-1F, -1F, -1F, 10, 2, 2),
				PartPose.offsetAndRotation(4F, 21F, -1F, 0F, -0.2792527F, 0.3490659F));

		partRoot.addOrReplaceChild("leg_5", CubeListBuilder.create().mirror()
						.texOffs(40, 0)
						.addBox(-9F, -1F, -1F, 10, 2, 2),
				PartPose.offsetAndRotation(-4F, 21F, -4F, 0F, -0.2792527F, -0.3490659F));

		partRoot.addOrReplaceChild("leg_6", CubeListBuilder.create()
						.texOffs(40, 0)
						.addBox(-1F, -1F, -1F, 10, 2, 2),
				PartPose.offsetAndRotation(4F, 21F, -4F, 0F, 0.2792527F, 0.3490659F));

		return LayerDefinition.create(mesh, 64, 32);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(FireBeetle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);

		float legZ = ((float) Math.PI / 11F);
		this.leg1.zRot = -legZ;
		this.leg2.zRot = legZ;
		this.leg3.zRot = -legZ * 0.74F;
		this.leg4.zRot = legZ * 0.74F;
		this.leg5.zRot = -legZ;
		this.leg6.zRot = legZ;

		float var9 = -0.0F;
		float var10 = 0.3926991F;
		this.leg1.yRot = var10 * 2.0F + var9;
		this.leg2.yRot = -var10 * 2.0F - var9;
		this.leg3.yRot = var10 + var9;
		this.leg4.yRot = -var10 - var9;
		this.leg5.yRot = -var10 * 2.0F + var9;
		this.leg6.yRot = var10 * 2.0F - var9;

		float var11 = -(Mth.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float var12 = -(Mth.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float var14 = -(Mth.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;

		float var15 = Math.abs(Mth.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float var16 = Math.abs(Mth.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float var18 = Math.abs(Mth.sin(limbSwing * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;

		this.leg1.yRot += var11;
		this.leg2.yRot -= var11;
		this.leg3.yRot += var12;
		this.leg4.yRot -= var12;
		this.leg5.yRot += var14;
		this.leg6.yRot -= var14;

		this.leg1.zRot += var15;
		this.leg2.zRot -= var15;

		this.leg3.zRot += var16;
		this.leg4.zRot -= var16;

		this.leg5.zRot += var18;
		this.leg6.zRot -= var18;
	}
}
