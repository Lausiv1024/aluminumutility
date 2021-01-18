package lausiv1024.blocks;

import java.util.Random;

import lausiv1024.AluminumUtility;
import lausiv1024.tileentity.TileEntityDaylightControllerNight;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class DaylightControllerNight extends Block implements ITileEntityProvider {
	public DaylightControllerNight() {
		super(Material.ROCK);
		this.setRegistryName(AluminumUtility.MODID, "daylight_controller_n");
		this.setUnlocalizedName("daylight_controller_n");
		this.setHardness(5.0f);
		this.setResistance(10.0f);
		this.setSoundType(blockSoundType.METAL);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		worldIn.setBlockState(pos, AluminumUtility.DAYLIGHT_CONTROLLER.getDefaultState(), 2);
		return true;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityDaylightControllerNight();
	}


	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(AluminumUtility.DAYLIGHT_CONTROLLER);
	}
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(AluminumUtility.DAYLIGHT_CONTROLLER);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(AluminumUtility.DAYLIGHT_CONTROLLER);
	}
}
