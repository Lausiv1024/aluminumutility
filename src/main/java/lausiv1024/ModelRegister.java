package lausiv1024;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegister {
	public static final String inv = "inventory";
	public static void RegisterModels() {
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUM, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.ALUMINUM_BLOCK)
				, 0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_block"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.ExProGlowstone), 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "ep_glowstone"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.EX_PRO_ALUMINUM_BLOCK),
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "ep_aluminium"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.CHAOS_BLOCK), 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "chaos_block"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ELEVATOR, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "elevator"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.HIGH_PRITY_GLASS),
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "high_prity_glass"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.ATAMANOWARUIHITO),
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "atamanowaruihito"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSWORD, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_sword"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSWORD1, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_sword1"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSWORD2, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_sword2"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSWORD3, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_sword3"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSWORD4, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_sword4"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSWORD5, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_sword5"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMPICKAXE, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_pickaxe"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMPICKAXE1, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_pickaxe1"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMPICKAXE2, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_pickaxe2"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMPICKAXE3, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_pickaxe3"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMPICKAXE4, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_pickaxe4"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMPICKAXE5, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_pickaxe5"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSHOVEL, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_shovel"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSHOVEL1, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_shovel1"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSHOVEL2, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_shovel2"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSHOVEL3, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_shovel3"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSHOVEL4, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_shovel4"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMSHOVEL5, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_shovel5"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMAXE, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_axe"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMAXE1, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_axe1"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMAXE2, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_axe2"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMAXE3, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_axe3"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMAXE4, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_axe4"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMAXE5, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_axe5"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.ALUMINUMPAXEL, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_paxel"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.COMPRESSED_ALUMINUM, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "compressed_aluminum_0"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.COMPRESSED_ALUMINUM, 1,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "compressed_aluminum_1"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.COMPRESSED_ALUMINUM, 2,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "compressed_aluminum_2"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.COMPRESSED_ALUMINUM, 3,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "compressed_aluminum_3"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.MAHOUCHUUKAN, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "mahou_chuukan_0"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.MAHOUCHUUKAN, 1,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "mahou_chuukan_1"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.TRANSPARENT_BLOCK),
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "transparent_block"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.FIRE_TOOL,
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "fire_tool"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.EYESIGHT_ENHANCER,
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "eyesight_enhancer"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.EYESIGHT_ENHANCER_ACTIVE,
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "eyesight_enhancer_a"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.EXPLOSION_TOOL,
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "explosion_tool"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.KAISHUU_TOOL, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "block_recovery_tool"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.ALUMINUM_BOX),
				0, new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_box"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.OMAMORI, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_amulet0"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.OMAMORI, 1,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_amulet1"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.OMAMORI, 2,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "aluminum_amulet2"), inv));
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.DOUBLING_BOX), 0,
		//		new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "doubling_box"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.DAYLIGHT_CONTROLLER), 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "daylight_controller"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.DAYLIGHT_CONTROLLER_NIGHT), 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "daylight_controller_n") , inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.CHAOS_BALL, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "chaos_ball"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.DEFENCE_AMULET, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "defence_amulet"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.FLYING_AMULET, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "flying_amulet"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.GOD_AMULET, 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "god_amulet"), inv));
		ModelLoader.setCustomModelResourceLocation(AluminumUtility.GOD_AMULET, 1,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "broken_god_amulet"), inv));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(AluminumUtility.LAUSIV_BLOCK), 0,
				new ModelResourceLocation(new ResourceLocation(AluminumUtility.MODID, "lausiv_block"), inv));
	}
}
