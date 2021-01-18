package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import lausiv1024.entity.EntityLausiv;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LausivBlock extends Block {
	public LausivBlock() {
		super(Material.ROCK);
		this.setRegistryName(AluminumUtility.MODID, "lausiv_block");
		this.setUnlocalizedName("lausiv_block");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setHardness(2.0f);
		this.setResistance(10);
		this.setHarvestLevel("pickaxe", 3);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		EntityLausiv lausiv = new EntityLausiv(worldIn);
		lausiv.moveToBlockPosAndAngles(pos, 0, 0);
		if (!worldIn.isRemote) {
			worldIn.spawnEntity(lausiv);
			worldIn.setBlockToAir(pos);
		}
		return true;
	}
}
