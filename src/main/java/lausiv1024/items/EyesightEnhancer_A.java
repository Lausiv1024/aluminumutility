package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EyesightEnhancer_A extends Item {
	public EyesightEnhancer_A() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "eyesight_enhancer_a");
		this.setUnlocalizedName("eyesight_enhancer");
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		int iindex = playerIn.inventory.currentItem;
		if (handIn == EnumHand.MAIN_HAND) {
			playerIn.removeActivePotionEffect(Potion.getPotionById(16));
			playerIn.inventory.setInventorySlotContents(iindex, new ItemStack(AluminumUtility.EYESIGHT_ENHANCER));
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		int potionid = 16;
		int duration = 20 * 20;
		//int amplifier = 0;
		PotionEffect effect = new PotionEffect(Potion.getPotionById(potionid), duration);
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			player.addPotionEffect(effect);
		}
	}
}
