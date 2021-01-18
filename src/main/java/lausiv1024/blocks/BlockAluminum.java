package lausiv1024.blocks;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAluminum extends Block {
	public BlockAluminum() {
		super(Material.IRON);
		this.setRegistryName(AluminumUtility.MODID, "aluminum_block");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("aluminum_block");
		this.setHardness(5.0f);
		this.setResistance(10.0f);
		this.setSoundType(SoundType.METAL);
		this.setHarvestLevel("pickaxe", 2);
		this.setLightLevel(1);
	}
}
