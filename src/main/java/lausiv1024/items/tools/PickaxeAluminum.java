package lausiv1024.items.tools;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class PickaxeAluminum extends ItemPickaxe {
	public PickaxeAluminum(ToolMaterial material, String registId) {
		super(material);
		this.setRegistryName(AluminumUtility.MODID, registId);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setUnlocalizedName(registId);
	}
}
