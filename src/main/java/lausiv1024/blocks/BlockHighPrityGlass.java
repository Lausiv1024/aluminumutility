package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHighPrityGlass extends Block {
	public BlockHighPrityGlass() {
		super(Material.GLASS);
		this.setRegistryName(AluminumUtility.MODID, "high_prity_glass");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("high_prity_glass");
		this.setSoundType(blockSoundType.GLASS);
		this.setLightOpacity(0);
		this.setHardness(0.3f);
		this.setResistance(5);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
