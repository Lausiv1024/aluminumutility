package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EyesightEnhancer extends Item {
	public EyesightEnhancer() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "eyesight_enhancer");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("eyesight_enhancer");
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		int iindex = playerIn.inventory.currentItem;
		if (handIn == EnumHand.MAIN_HAND)
		playerIn.inventory.setInventorySlotContents(iindex, new ItemStack(AluminumUtility.EYESIGHT_ENHANCER_ACTIVE));
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
}
