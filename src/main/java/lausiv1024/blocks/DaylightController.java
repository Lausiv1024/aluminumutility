package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import lausiv1024.tileentity.TileEntityDayloghtController;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DaylightController extends Block implements ITileEntityProvider {
	public DaylightController() {
		super(Material.ROCK);
		this.setRegistryName(AluminumUtility.MODID, "daylight_controller");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("daylight_controller");
		this.setHardness(5.0f);
		this.setResistance(10.0f);
		this.setSoundType(blockSoundType.METAL);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		worldIn.setBlockState(pos, AluminumUtility.DAYLIGHT_CONTROLLER_NIGHT.getDefaultState(), 2);
		return true;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO 自動生成されたメソッド・スタブ
		return new TileEntityDayloghtController();
	}

}
