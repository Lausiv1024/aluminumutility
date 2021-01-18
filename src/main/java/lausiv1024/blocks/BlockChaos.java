package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockChaos extends Block {
	public BlockChaos() {
		super(Material.ROCK);
		this.setRegistryName(AluminumUtility.MODID, "chaos_block");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("chaos_block");
		this.setHardness(10);
		this.setResistance(50);
		this.setLightLevel(1);
		this.setHarvestLevel("pickaxe", 3);
	}
}
