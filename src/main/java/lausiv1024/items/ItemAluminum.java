package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.item.Item;

public class ItemAluminum extends Item {
	public ItemAluminum() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "aluminum");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("aluminum");
	}
}
