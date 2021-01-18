package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ExProGlowstone extends Block {
	public ExProGlowstone() {
		super(Material.GLASS);
		this.setRegistryName(AluminumUtility.MODID, "ep_glowstone");
		this.setUnlocalizedName("ep_glowstone");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setResistance(2000);
		this.setHardness(0.3f);
		this.setSoundType(blockSoundType.GLASS);
		this.setLightLevel(1);
	}
}
