package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.BlockStairs;

public class AluminumStair extends BlockStairs {
	public AluminumStair() {
		super(AluminumUtility.ALUMINUM_BLOCK.getDefaultState());
		this.setRegistryName(AluminumUtility.MODID, "aluminum_stairs");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("aluminum_stairs");
	}
}
