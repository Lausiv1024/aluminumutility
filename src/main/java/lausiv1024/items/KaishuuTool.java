package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KaishuuTool extends Item {
	public KaishuuTool() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "block_recovery_tool");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("block_recovery_tool");
		this.setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		IBlockState state = worldIn.getBlockState(pos);
		int meta = state.getBlock().getMetaFromState(state);
		worldIn.setBlockToAir(pos);
		player.inventory.addItemStackToInventory(new ItemStack(state.getBlock(), 1, meta));
		return EnumActionResult.PASS;
	}
}
