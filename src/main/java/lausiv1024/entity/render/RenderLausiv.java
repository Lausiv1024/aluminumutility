package lausiv1024.entity.render;

import lausiv1024.AluminumUtility;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderLausiv extends RenderLiving<EntityLiving> {
	public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(AluminumUtility.MODID, "textures/entities/lausiv.png");


	public RenderLausiv(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		// TODO 自動生成されたメソッド・スタブ
		return TEXTURE_LOCATION;
	}

}
