package lausiv1024.items.tools;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class AxeAluminum extends ItemAxe {
	public AxeAluminum(ToolMaterial material, String registName, float damage, float speed) {
		super(material, damage, speed);
		this.setRegistryName(AluminumUtility.MODID, registName);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setUnlocalizedName(registName);
	}
}
