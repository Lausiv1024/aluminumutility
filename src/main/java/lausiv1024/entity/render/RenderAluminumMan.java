package lausiv1024.entity.render;

import lausiv1024.AluminumUtility;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderAluminumMan extends RenderLiving<EntityLiving> {
	public static final ResourceLocation texture = new ResourceLocation(AluminumUtility.MODID, "textures/entities/aluminum_man.png");

	public RenderAluminumMan(RenderManager manager, ModelBase base, float shadownsize) {
		super(manager, base, shadownsize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}


}
