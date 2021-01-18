package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ExplosionTool extends Item {
	public ExplosionTool() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "explosion_tool");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("explosion_tool");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!playerIn.capabilities.isCreativeMode) {
			playerIn.getHeldItem(handIn).setCount(playerIn.getHeldItem(handIn).getCount() - 1);
		}
		if (!worldIn.isRemote) {
			worldIn.newExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, 150, false, true);
			playerIn.sendMessage(new TextComponentString("Explsion!"));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
