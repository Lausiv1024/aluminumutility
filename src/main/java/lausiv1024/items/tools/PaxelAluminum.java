package lausiv1024.items.tools;

import lausiv1024.AluminumUtility;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class PaxelAluminum extends ItemTool {
	//public static final Set<Block> EFFECTIVE =

	public PaxelAluminum(ToolMaterial material, String registId) {
		super(material, null);
		setRegistryName(AluminumUtility.MODID, registId);
		setCreativeTab(CreativeTabs.TOOLS);
		setUnlocalizedName(registId);
	}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		return this.efficiency;
	}

	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
		return true;
	}

	@Override
	public void setDamage(ItemStack stack, int damage) {
		super.setDamage(stack, 0);
	}
}
