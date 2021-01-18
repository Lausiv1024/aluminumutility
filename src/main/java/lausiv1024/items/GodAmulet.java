package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class GodAmulet extends Item {
	public static final int ITEMCOUNT = 2;
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
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getItemDamage();
		return this.getUnlocalizedName() + "." + meta;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < ITEMCOUNT; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
}
