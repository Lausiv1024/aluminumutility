package lausiv1024;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AlumiTab extends CreativeTabs {
	public AlumiTab() {
		super("alumi");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(AluminumUtility.ALUMINUM);
	}

}
