package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TransparentBlock extends Block {
	public TransparentBlock() {
		super(Material.CLAY);
		setRegistryName(AluminumUtility.MODID, "transparent_block");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("transparent_block");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		// TODO 自動生成されたメソッド・スタブ
		return BlockRenderLayer.CUTOUT;
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
}
