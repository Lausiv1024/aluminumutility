package lausiv1024.items.tools;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireTool extends Item {
	public FireTool() {
		super();
		setRegistryName(AluminumUtility.MODID, "fire_tool");
		setCreativeTab(AluminumUtility.alumiTab);
		setUnlocalizedName("fire_tool");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		PotionEffect effect = new PotionEffect(Potion.getPotionById(12), 1000);
		playerIn.addPotionEffect(effect);
		double start_ichiX = playerIn.posX - 5;
		double start_ichiZ = playerIn.posZ - 6;
		double end_posX = playerIn.posX + 5;
		double end_posZ = playerIn.posZ + 5;
		for (int i = 0;i < 5;i++) {
			for (int ui = 0;ui < 11;ui++) {
				SetFireOnBlock(worldIn, (int)start_ichiX + ui, (int)playerIn.posY, (int)start_ichiZ + i);
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int ui = 0; ui < 11; ui++) {
				SetFireOnBlock(worldIn, (int)end_posX - ui, (int)playerIn.posY, (int)end_posZ - i);
			}
		}

		playerIn.playSound(SoundEvents.ENTITY_GHAST_SHOOT, 1, 1);
		if (!playerIn.capabilities.isCreativeMode) {
			playerIn.getHeldItem(handIn).setCount(playerIn.getHeldItem(handIn).getCount());
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}


	private void SetFireOnBlock(World world, int x, int y, int z) {
		int jougen = y + 20;
		boolean jougend = false;
		while (world.getBlockState(new BlockPos(x, y, z)).getBlock() != Blocks.AIR) {
			y++;
			if (y >= jougen) {
				jougend = true;
				break;
			}
		}
		if (!jougend) {
			world.setBlockState(new BlockPos(x, y, z),
					Block.getStateById(Block.getIdFromBlock(Blocks.FIRE)));
		}
	}
}
