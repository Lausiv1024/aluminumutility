package lausiv1024.blocks;

import java.util.Random;

import lausiv1024.AluminumUtility;
import lausiv1024.tileentity.TileEntityDoublingBox;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class DoublingBox extends Block {
	private boolean IsItemExists = false;
	public DoublingBox() {
		super(Material.WOOD);
		this.setRegistryName(AluminumUtility.MODID, "doubling_box");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("doubling_box");
		this.setHardness(0.5f);
		this.setResistance(10);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityDoublingBox();
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}


	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		playerIn.sendMessage(new TextComponentString("111"));
		ItemStack stack = playerIn.inventory.getCurrentItem().copy();
		TileEntityDoublingBox doublingBox = (TileEntityDoublingBox) worldIn.getTileEntity(pos);
		if (stack == null) {
			if (!worldIn.isRemote && doublingBox != null) {
				ItemStack iiStack = doublingBox.getKioku();
				if (iiStack != null){
					playerIn.sendMessage(new TextComponentString(iiStack.getDisplayName()));
				}
				return false;
			}
		}

		if (doublingBox != null && !worldIn.isRemote) {
			if (doublingBox.getKioku() == null) {
				doublingBox.setKioku(stack);
				playerIn.sendMessage(new TextComponentString(stack.getDisplayName()));
				if (!playerIn.capabilities.isCreativeMode) {
					stack.setCount(stack.getCount()- 1);
				}
			}
			else {
				if (!stack.equals(doublingBox.getKioku())) {
					ItemStack pastitem = doublingBox.getKioku();
					SpawnItemEntity(worldIn, pastitem, hitX, hitY, hitZ, true);
					doublingBox.setKioku(stack);
					playerIn.sendMessage(new TextComponentString(stack.getDisplayName()));
					if (!playerIn.capabilities.isCreativeMode) {
						stack.setCount(stack.getCount() - 1);
					}
				}
			}
		}

		return true;
	}

	private void SpawnItemEntity(World world, ItemStack stack, float x, float y, float z, boolean mode) {
		if (stack == null) {
			return;
		}
		int kaisuu;
		if (mode)
			kaisuu = 1;
		else
			kaisuu = 2;
		for (int i = 0; i < kaisuu; i++) {
			EntityItem entityItem;
			if (!mode)
			entityItem = new EntityItem(world, x, y, z,
					new ItemStack(stack.getItem(), 64, stack.getItemDamage()));
			else entityItem = new EntityItem(world, x, y, z,
					new ItemStack(stack.getItem(), 1, stack.getItemDamage()));

			if (stack.hasTagCompound()) {

			}
			world.spawnEntity(entityItem);
		}
	}
}
