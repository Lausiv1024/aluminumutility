package lausiv1024.blocks;

import java.util.Random;

import lausiv1024.AluminumUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class AluminumBox extends Block {
	private Random random = new Random();
	public AluminumBox() {
		super(Material.ROCK);
		this.setRegistryName(AluminumUtility.MODID, "aluminum_box");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("aluminum_box");
		this.setHardness(3.0f);
		this.setResistance(5.0f);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		int i = random.nextInt(1000);
		if (i > 990) {
			return AluminumUtility.COMPRESSED_ALUMINUM;
		}else if (i > 700) {
			return Item.getItemFromBlock(AluminumUtility.ALUMINUM_BLOCK);
		}
		return AluminumUtility.ALUMINUM;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(AluminumUtility.ALUMINUM_BOX.getDefaultState(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0) {
				i = 0;
			}
			return this.quantityDropped(random) * (i + 1);
		}
		else {
			return this.quantityDropped(random);
		}
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		return 500;
	}
}
