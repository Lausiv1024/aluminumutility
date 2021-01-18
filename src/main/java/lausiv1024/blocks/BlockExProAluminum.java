package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockExProAluminum extends Block {
	public BlockExProAluminum() {
		super(Material.ROCK);
		this.setRegistryName(AluminumUtility.MODID, "ep_aluminium");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setSoundType(blockSoundType.METAL);
		this.setUnlocalizedName("ep_aluminium");
		this.setHardness(5.0f);
		this.setResistance(2000);
		this.setHarvestLevel("pickaxe", 2);
		this.setLightLevel(1);
	}
}
