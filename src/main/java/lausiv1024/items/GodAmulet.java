package lausiv1024.items;

import java.util.List;

import lausiv1024.AluminumUtility;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class GodAmulet extends Item {
	public static final int ITEMCOUNT = 3;
	public GodAmulet() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "god_amulet");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("god_amulet");
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			player.setAir(300);
			player.getFoodStats().addStats(20, 20);
			player.setHealth(player.getMaxHealth());
			if (player.isBurning()) {
				player.extinguish();
			}
		}
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		switch (stack.getItemDamage()) {
		case 0:
			tooltip.add("JumpBoost:ON");
			break;

		case 2:
			tooltip.add("JumpBoost:OFF");
			break;
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getItemDamage();
		if (meta < 2)
			return this.getUnlocalizedName() + "." + meta;
		return this.getUnlocalizedName() + ".0";
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < ITEMCOUNT; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		switch (playerIn.getHeldItem(handIn).getItemDamage()) {
		case 0:
			playerIn.setHeldItem(handIn, new ItemStack(AluminumUtility.GOD_AMULET, 1, 2));
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
		case 2:
			playerIn.setHeldItem(handIn, new ItemStack(AluminumUtility.GOD_AMULET, 1, 0));
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
