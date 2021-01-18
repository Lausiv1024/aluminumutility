package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMahouChuukan extends Item {
	public static final int kosuu = 2;
	public ItemMahouChuukan() {
		super();
		setRegistryName(AluminumUtility.MODID, "mahou_chuukan");
		setCreativeTab(AluminumUtility.alumiTab);
		setUnlocalizedName("mahou_chuukan");
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getMetadata();
		return super.getUnlocalizedName(stack) + "." + meta;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (isInCreativeTab(tab)) {
			for (int i = 0; i < kosuu; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
}
