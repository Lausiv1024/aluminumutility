package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class Elevator extends Item {
	public Elevator() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "elevator");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("elevator");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		int res = 0;
		if (!playerIn.isSneaking()) {
			res = goingUp(playerIn, worldIn);
			if (res > 0) {
				playerIn.setPosition(playerIn.posX, res, playerIn.posZ);
				playerIn.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
				if (!worldIn.isRemote) {
					if (!playerIn.capabilities.isCreativeMode) playerIn.getHeldItem(handIn.MAIN_HAND).setCount(playerIn.getHeldItem(handIn.MAIN_HAND).getCount() - 1);
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn.MAIN_HAND));
				}
			}else {
				if (!worldIn.isRemote) {
					playerIn.sendMessage(new TextComponentString("Can't find your overhead block."));
				}
			}
		}else {
			int res2 = goingDown(playerIn, worldIn);
			if (res2 > 0) {
				playerIn.setPosition(playerIn.posX, res2, playerIn.posZ);
				playerIn.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1, 1);
				if (!worldIn.isRemote) {
					if (!playerIn.capabilities.isCreativeMode) playerIn.getHeldItem(handIn.MAIN_HAND).setCount(playerIn.getHeldItem(handIn.MAIN_HAND).getCount() - 1);
				}
				return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn.MAIN_HAND));
			}else {
				if (!worldIn.isRemote) {
					playerIn.sendMessage(new TextComponentString("Can't find downstairs."));
				}
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	private int goingUp(EntityPlayer player, World world) {
		int bashoY = MathHelper.floor(player.posY);
		for (int i = 2; i < 202; i++) {
			if (world.getBlockState(new BlockPos(player.posX, bashoY + i, player.posZ)).getBlock() != Blocks.AIR) {
				int tmp = bashoY + i;
				Block legBlock = world.getBlockState(new BlockPos(player.posX, tmp + 1, player.posZ)).getBlock();
				Block headBlock = world.getBlockState(new BlockPos(player.posX, tmp + 2, player.posZ)).getBlock();
				if (legBlock == Blocks.AIR && headBlock == Blocks.AIR) {
					return tmp + 1;
				}
			}
		}
		return -1;
	}

	private int goingDown(EntityPlayer player, World world) {
		for (int i = 0; i < 200; i++) {
			if (world.getBlockState(new BlockPos(player.posX, player.posY - i, player.posZ)).getBlock() == Blocks.AIR) {
				int tmp = MathHelper.floor(player.posY) - i;
				if (world.getBlockState(new BlockPos(player.posX, tmp - 1, player.posZ)).getBlock() == Blocks.AIR &&
						world.getBlockState(new BlockPos(player.posX, tmp - 2, player.posZ)).getBlock() != Blocks.AIR) {
					return tmp - 1;
				}
			}
		}
		return -114514;
	}
}
