package lausiv1024.items.tools;

import lausiv1024.AluminumUtility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ShovelAluminum extends ItemSpade {
	public ShovelAluminum(ToolMaterial material, String registName) {
		super(material);
		this.setRegistryName(AluminumUtility.MODID, registName);
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setUnlocalizedName(registName);
	}
}
