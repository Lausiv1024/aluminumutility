package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class Omamori extends Item {
	public static final int kosuu = 3;
	public Omamori() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "aluminum_amulet");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("aluminum_amulet");
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getItemDamage();
		return super.getUnlocalizedName(stack) + "." + meta;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < kosuu; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
	@Override
	public int getItemStackLimit(ItemStack stack) {
		int meta = stack.getItemDamage();
		if (meta == 2) {
			return 1;
		}
		return super.getItemStackLimit(stack);
	}
}
