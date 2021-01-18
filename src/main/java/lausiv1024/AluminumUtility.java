package lausiv1024;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lausiv1024.blocks.AluminumBox;
import lausiv1024.blocks.BlockAluminum;
import lausiv1024.blocks.BlockAtama;
import lausiv1024.blocks.BlockChaos;
import lausiv1024.blocks.BlockExProAluminum;
import lausiv1024.blocks.BlockHighPrityGlass;
import lausiv1024.blocks.DaylightController;
import lausiv1024.blocks.DaylightControllerNight;
import lausiv1024.blocks.DoublingBox;
import lausiv1024.blocks.ExProGlowstone;
import lausiv1024.blocks.LausivBlock;
import lausiv1024.blocks.TransparentBlock;
import lausiv1024.entity.AluminuMan;
import lausiv1024.entity.EntityChaosBall;
import lausiv1024.entity.EntityLausiv;
import lausiv1024.entity.render.RenderAluminumMan;
import lausiv1024.entity.render.RenderChaosBall;
import lausiv1024.entity.render.RenderLausiv;
import lausiv1024.items.AluminumCompressed;
import lausiv1024.items.DefenceAmulet;
import lausiv1024.items.Elevator;
import lausiv1024.items.ExplosionTool;
import lausiv1024.items.EyesightEnhancer;
import lausiv1024.items.EyesightEnhancer_A;
import lausiv1024.items.FlyingAmulet;
import lausiv1024.items.GodAmulet;
import lausiv1024.items.ItemAluminum;
import lausiv1024.items.ItemChaosBall;
import lausiv1024.items.ItemMahouChuukan;
import lausiv1024.items.KaishuuTool;
import lausiv1024.items.Omamori;
import lausiv1024.items.tools.AxeAluminum;
import lausiv1024.items.tools.FireTool;
import lausiv1024.items.tools.PaxelAluminum;
import lausiv1024.items.tools.PickaxeAluminum;
import lausiv1024.items.tools.ShovelAluminum;
import lausiv1024.items.tools.SwordAluminum;
import lausiv1024.tileentity.TileEntityDaylightControllerNight;
import lausiv1024.tileentity.TileEntityDayloghtController;
import lausiv1024.tileentity.TileEntityDoublingBox;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid=AluminumUtility.MODID, name=AluminumUtility.MODNAME, version=AluminumUtility.MODVERSION)
public class AluminumUtility {
	public static final String MODID = "aluminumutility";
	public static final String MODNAME = "Aluminum Utility";
	public static final String MODVERSION = "2.0";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static final Biome[] OverWorld = {
			Biomes.BEACH,
			Biomes.BIRCH_FOREST,
			Biomes.BIRCH_FOREST_HILLS,
			Biomes.COLD_BEACH,
			Biomes.COLD_TAIGA,
			Biomes.DESERT,
			Biomes.DESERT_HILLS,
			Biomes.EXTREME_HILLS,
			Biomes.EXTREME_HILLS_EDGE,
			Biomes.EXTREME_HILLS_WITH_TREES,
			Biomes.FOREST,
			Biomes.FOREST_HILLS,
			Biomes.ICE_MOUNTAINS,
			Biomes.ICE_PLAINS,
			Biomes.JUNGLE,
			Biomes.JUNGLE_EDGE,
			Biomes.JUNGLE_HILLS,
			Biomes.TAIGA,
			Biomes.TAIGA_HILLS,
			Biomes.MESA,
			Biomes.MUTATED_MESA,
			Biomes.MESA_ROCK,
			Biomes.MUSHROOM_ISLAND,
			Biomes.MUSHROOM_ISLAND_SHORE,
			Biomes.PLAINS,
			Biomes.ROOFED_FOREST,
			Biomes.SAVANNA,
			Biomes.SAVANNA_PLATEAU,
			Biomes.STONE_BEACH,
			Biomes.SWAMPLAND,
			Biomes.REDWOOD_TAIGA,
			Biomes.MUTATED_SWAMPLAND
	};

	//public static final Advancement CREATE_ALUMINUM = new Advancement(new ResourceLocation(MODNAME, "get_aluminum"),
			//null, null, null, null, null);

	public static final CreativeTabs alumiTab = new AlumiTab();

	public static final ToolMaterial M_ALUMINUM = EnumHelper.addToolMaterial("M_ALUMINUM", 2, 20, 7.5f, 1.5f, 10);
	public static final ToolMaterial M_ALUMINUM1 = EnumHelper.addToolMaterial("M_ALUMINUM1", 3, 250, 7.5f, 9, 10);
	public static final ToolMaterial M_ALUMINUM2 = EnumHelper.addToolMaterial("M_ALUMINUM2", 3, 1500, 9f, 81, 10);
	public static final ToolMaterial M_ALUMINUM3 = EnumHelper.addToolMaterial("M_ALUMINUM3", 3, 5000, 20f, 729, 15);
	public static final ToolMaterial M_ALUMINUM4 =  EnumHelper.addToolMaterial("M_ALUMINUM4", 3, 15000, 180f, 6561, 20);
	public static final ToolMaterial M_ALUMINUM5 = EnumHelper.addToolMaterial("M_ALUMINUM5", 3, 100000, 1620, 531441, 30);

	public static final Item ALUMINUM = new ItemAluminum();
	public static final Item ELEVATOR = new Elevator();
	public static final Item COMPRESSED_ALUMINUM = new AluminumCompressed();
	public static final Item KAISHUU_TOOL = new KaishuuTool();
	public static final Item OMAMORI = new Omamori();

	public static final Item ALUMINUMSWORD = new SwordAluminum(M_ALUMINUM, "aluminum_sword");
	public static final Item ALUMINUMSWORD1 = new SwordAluminum(M_ALUMINUM1, "aluminum_sword1");
	public static final Item ALUMINUMSWORD2 = new SwordAluminum(M_ALUMINUM2, "aluminum_sword2");
	public static final Item ALUMINUMSWORD3 = new SwordAluminum(M_ALUMINUM3, "aluminum_sword3");
	public static final Item ALUMINUMSWORD4 = new SwordAluminum(M_ALUMINUM4, "aluminum_sword4");
	public static final Item ALUMINUMSWORD5 = new SwordAluminum(M_ALUMINUM5, "aluminum_sword5")
			{
		public void setDamage(ItemStack stack, int damage) {super.setDamage(stack, 0);};
			};
	public static final Item ALUMINUMPICKAXE = new PickaxeAluminum(M_ALUMINUM, "aluminum_pickaxe");
	public static final Item ALUMINUMPICKAXE1 = new PickaxeAluminum(M_ALUMINUM1, "aluminum_pickaxe1");
	public static final Item ALUMINUMPICKAXE2 = new PickaxeAluminum(M_ALUMINUM2, "aluminum_pickaxe2");
	public static final Item ALUMINUMPICKAXE3 = new PickaxeAluminum(M_ALUMINUM3, "aluminum_pickaxe3");
	public static final Item ALUMINUMPICKAXE4 = new PickaxeAluminum(M_ALUMINUM4, "aluminum_pickaxe4");
	public static final Item ALUMINUMPICKAXE5 = new PickaxeAluminum(M_ALUMINUM5, "aluminum_pickaxe5") {
		public void setDamage(ItemStack stack, int damage) {super.setDamage(stack, 0);};
	};

	public static final Item ALUMINUMSHOVEL = new ShovelAluminum(M_ALUMINUM, "aluminum_shovel");
	public static final Item ALUMINUMSHOVEL1 = new ShovelAluminum(M_ALUMINUM1, "aluminum_shovel1");
	public static final Item ALUMINUMSHOVEL2 = new ShovelAluminum(M_ALUMINUM2, "aluminum_shovel2");
	public static final Item ALUMINUMSHOVEL3 = new ShovelAluminum(M_ALUMINUM3, "aluminum_shovel3");
	public static final Item ALUMINUMSHOVEL4 = new ShovelAluminum(M_ALUMINUM4, "aluminum_shovel4");
	public static final Item ALUMINUMSHOVEL5 = new ShovelAluminum(M_ALUMINUM5, "aluminum_shovel5"){
		public void setDamage(ItemStack stack, int damage) {super.setDamage(stack, 0);};
	};

	public static final Item ALUMINUMAXE = new AxeAluminum(M_ALUMINUM, "aluminum_axe", 1.5f, 7.5f);
	public static final Item ALUMINUMAXE1 = new AxeAluminum(M_ALUMINUM1, "aluminum_axe1", 9, 7.5f);
	public static final Item ALUMINUMAXE2 = new AxeAluminum(M_ALUMINUM2, "aluminum_axe2", 81, 9f);
	public static final Item ALUMINUMAXE3 = new AxeAluminum(M_ALUMINUM3, "aluminum_axe3", 729, 20f);
	public static final Item ALUMINUMAXE4 = new AxeAluminum(M_ALUMINUM4, "aluminum_axe4", 6561, 180f);
	public static final Item ALUMINUMAXE5 = new AxeAluminum(M_ALUMINUM5, "aluminum_axe5", 531441, 1620) {
		public void setDamage(ItemStack stack, int damage) {super.setDamage(stack, 0);};
	};

	public static final Item ALUMINUMPAXEL = new PaxelAluminum(M_ALUMINUM5, "aluminum_paxel");
	public static final Item MAHOUCHUUKAN = new ItemMahouChuukan();
	public static final Item FIRE_TOOL = new FireTool();
	public static final Item EXPLOSION_TOOL = new ExplosionTool();
	public static final Item EYESIGHT_ENHANCER = new EyesightEnhancer();
	public static final Item EYESIGHT_ENHANCER_ACTIVE = new EyesightEnhancer_A();
	public static final Item CHAOS_BALL = new ItemChaosBall();
	public static final Item DEFENCE_AMULET = new DefenceAmulet();
	public static final Item FLYING_AMULET = new FlyingAmulet();
	public static final Item GOD_AMULET = new GodAmulet();

	public static final Block ALUMINUM_BLOCK = new BlockAluminum();
	public static final Block ExProGlowstone = new ExProGlowstone();
	public static final Block EX_PRO_ALUMINUM_BLOCK = new BlockExProAluminum();
	public static final Block CHAOS_BLOCK = new BlockChaos();
	public static final Block HIGH_PRITY_GLASS = new BlockHighPrityGlass();
	public static final Block ATAMANOWARUIHITO = new BlockAtama();
	//public static final Block ALUMINUM_STAIRS = new AluminumStair();
	public static final Block TRANSPARENT_BLOCK = new TransparentBlock();
	public static final Block ALUMINUM_BOX = new AluminumBox();
	public static final Block DOUBLING_BOX = new DoublingBox();
	public static final Block DAYLIGHT_CONTROLLER = new DaylightController();
	public static final Block DAYLIGHT_CONTROLLER_NIGHT = new DaylightControllerNight();
	public static final Block LAUSIV_BLOCK = new LausivBlock();

	@Mod.EventHandler
	public void construct(FMLConstructionEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new AlumiSEvent());
	}

	@SubscribeEvent
	public void resigterItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(ALUMINUM);
		event.getRegistry().register(ELEVATOR);
		event.getRegistry().register(ALUMINUMSWORD);
		event.getRegistry().register(ALUMINUMSWORD1);
		event.getRegistry().register(ALUMINUMSWORD2);
		event.getRegistry().register(ALUMINUMSWORD3);
		event.getRegistry().register(ALUMINUMSWORD4);
		event.getRegistry().register(ALUMINUMSWORD5);
		event.getRegistry().register(ALUMINUMPICKAXE);
		event.getRegistry().register(ALUMINUMPICKAXE1);
		event.getRegistry().register(ALUMINUMPICKAXE2);
		event.getRegistry().register(ALUMINUMPICKAXE3);
		event.getRegistry().register(ALUMINUMPICKAXE4);
		event.getRegistry().register(ALUMINUMPICKAXE5);
		event.getRegistry().register(ALUMINUMSHOVEL);
		event.getRegistry().register(ALUMINUMSHOVEL1);
		event.getRegistry().register(ALUMINUMSHOVEL2);
		event.getRegistry().register(ALUMINUMSHOVEL3);
		event.getRegistry().register(ALUMINUMSHOVEL4);
		event.getRegistry().register(ALUMINUMSHOVEL5);
		event.getRegistry().register(ALUMINUMAXE);
		event.getRegistry().register(ALUMINUMAXE1);
		event.getRegistry().register(ALUMINUMAXE2);
		event.getRegistry().register(ALUMINUMAXE3);
		event.getRegistry().register(ALUMINUMAXE4);
		event.getRegistry().register(ALUMINUMAXE5);
		event.getRegistry().register(ALUMINUMPAXEL);
		event.getRegistry().register(COMPRESSED_ALUMINUM);
		event.getRegistry().register(MAHOUCHUUKAN);
		event.getRegistry().register(FIRE_TOOL);
		event.getRegistry().register(EYESIGHT_ENHANCER);
		event.getRegistry().register(EYESIGHT_ENHANCER_ACTIVE);
		event.getRegistry().register(EXPLOSION_TOOL);
		event.getRegistry().register(KAISHUU_TOOL);
		event.getRegistry().register(OMAMORI);
		event.getRegistry().register(CHAOS_BALL);
		event.getRegistry().register(DEFENCE_AMULET);
		event.getRegistry().register(FLYING_AMULET);
		event.getRegistry().register(GOD_AMULET);

		event.getRegistry().register(new ItemBlock(ALUMINUM_BLOCK).setRegistryName(MODID, "aluminum_block"));
		event.getRegistry().register(new ItemBlock(ExProGlowstone).setRegistryName(MODID, "ep_glowstone"));
		event.getRegistry().register(new ItemBlock(EX_PRO_ALUMINUM_BLOCK).setRegistryName(MODID, "ep_aluminium"));
		event.getRegistry().register(new ItemBlock(CHAOS_BLOCK).setRegistryName(MODID, "chaos_block"));
		event.getRegistry().register(new ItemBlock(HIGH_PRITY_GLASS).setRegistryName(MODID, "high_prity_glass"));
		event.getRegistry().register(new ItemBlock(ATAMANOWARUIHITO).setRegistryName(MODID, "atamanowaruihito"));
		//event.getRegistry().register(new ItemBlock(ALUMINUM_STAIRS).setRegistryName(MODID, "aluminum_stairs"));
		event.getRegistry().register(new ItemBlock(TRANSPARENT_BLOCK).setRegistryName(MODID, "transparent_block"));
		event.getRegistry().register(new ItemBlock(ALUMINUM_BOX).setRegistryName(MODID, "aluminum_box"));
		//event.getRegistry().register(new ItemBlock(DOUBLING_BOX).setRegistryName(MODID, "doubling_box"));
		event.getRegistry().register(new ItemBlock(DAYLIGHT_CONTROLLER).setRegistryName(MODID, "daylight_controller"));
		event.getRegistry().register(new ItemBlock(DAYLIGHT_CONTROLLER_NIGHT).setRegistryName(MODID, "daylight_controller_n"));
		event.getRegistry().register(new ItemBlock(LAUSIV_BLOCK).setRegistryName(MODID, "lausiv_block"));
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(ALUMINUM_BLOCK);
		event.getRegistry().register(ExProGlowstone);
		event.getRegistry().register(EX_PRO_ALUMINUM_BLOCK);
		event.getRegistry().register(CHAOS_BLOCK);
		event.getRegistry().register(HIGH_PRITY_GLASS);
		event.getRegistry().register(ATAMANOWARUIHITO);
		//event.getRegistry().register(ALUMINUM_STAIRS);
		event.getRegistry().register(TRANSPARENT_BLOCK);
		event.getRegistry().register(ALUMINUM_BOX);
		//event.getRegistry().register(DOUBLING_BOX);
		event.getRegistry().register(DAYLIGHT_CONTROLLER);
		event.getRegistry().register(DAYLIGHT_CONTROLLER_NIGHT);
		event.getRegistry().register(LAUSIV_BLOCK);
	}

	//public static void registerTE(RegistryEvent.Register<TileEntity>)

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerTileEntity(TileEntityDoublingBox.class, new ResourceLocation(MODID, "tileentity_doublingbox"));
		GameRegistry.registerTileEntity(TileEntityDayloghtController.class, new ResourceLocation(MODID, "tileentity_daylightcontroller"));
		GameRegistry.registerTileEntity(TileEntityDaylightControllerNight.class, new ResourceLocation(MODID, "tileentity_dailightcontrollernight"));
		if (event.getSide().isClient()) {

			RenderingRegistry.registerEntityRenderingHandler(AluminuMan.class, new IRenderFactory<AluminuMan>() {

				@Override
				public Render<? super AluminuMan> createRenderFor(RenderManager manager) {
					return new RenderAluminumMan(manager, new ModelBiped(), 0.6f);
				}
			});

			RenderingRegistry.registerEntityRenderingHandler(EntityChaosBall.class, new IRenderFactory<EntityChaosBall>() {

				@Override
				public Render<? super EntityChaosBall> createRenderFor(RenderManager manager) {
					return new RenderChaosBall(manager, CHAOS_BALL, Minecraft.getMinecraft().getRenderItem());
				}
			});

			RenderingRegistry.registerEntityRenderingHandler(EntityLausiv.class, new IRenderFactory() {
				@Override
				public Render<? super EntityLausiv> createRenderFor(RenderManager manager) {
					// TODO 自動生成されたメソッド・スタブ
					return new RenderLausiv(manager, new ModelBiped(), 0.6f);
				}
			});
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		GameRegistry.addSmelting(Blocks.IRON_BLOCK, new ItemStack(ALUMINUM), 1.0f);
		GameRegistry.addSmelting(Blocks.GLASS, new ItemStack(HIGH_PRITY_GLASS), 0.5f);
		EntityRegistry.registerModEntity(new ResourceLocation("aluminum_man"), AluminuMan.class, "aluminum_man", 1, this, 50, 1, true, 0xbdbdbd, 0xdfdfdf);
		EntityRegistry.registerModEntity(new ResourceLocation("entity_chaos_ball"), EntityChaosBall.class, "entity_chaos_ball", 2, this, 50, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("lausiv"), EntityLausiv.class, "lausiv", 3, this, 50, 1, true, 0x090091, 0);
		EntityRegistry.addSpawn(AluminuMan.class, 20, 1, 10, EnumCreatureType.MONSTER, OverWorld);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelRegister.RegisterModels();
	}
}
