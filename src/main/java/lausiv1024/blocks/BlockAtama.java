package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAtama extends Block {
	public BlockAtama() {
		super(Material.GRASS);
		this.setRegistryName(AluminumUtility.MODID, "atamanowaruihito");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("atamanowaruihito");
		this.setHardness(0.1f);
		this.setResistance(1.0f);
	}
}
