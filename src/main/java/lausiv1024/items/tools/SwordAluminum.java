package lausiv1024.items.tools;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class SwordAluminum extends ItemSword {
	public SwordAluminum(ToolMaterial material, String registName) {
		super(material);
		setRegistryName(AluminumUtility.MODID, registName);
		setCreativeTab(CreativeTabs.COMBAT);
		setUnlocalizedName(registName);
	}
}
