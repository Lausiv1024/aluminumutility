package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class AluminumCompressed extends Item {
	public static final int itemcount = 4;

	public AluminumCompressed() {
		super();
		setRegistryName(AluminumUtility.MODID, "compressed_aluminum");
		setUnlocalizedName("compressed_aluminum");
		setCreativeTab(AluminumUtility.alumiTab);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getMetadata();
		return super.getUnlocalizedName() + "." + meta;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < itemcount; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
}
