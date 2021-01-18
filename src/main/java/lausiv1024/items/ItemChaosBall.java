package lausiv1024.items;

import lausiv1024.AluminumUtility;
import lausiv1024.entity.EntityChaosBall;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemChaosBall extends Item {
	public ItemChaosBall() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "chaos_ball");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("chaos_ball");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		EntityChaosBall ball = new EntityChaosBall(worldIn, playerIn);
		ball.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
		worldIn.spawnEntity(ball);

		if (!playerIn.capabilities.isCreativeMode) {
			ItemStack helditem = playerIn.getHeldItem(handIn);
			helditem.setCount(helditem.getCount() - 1);
		}

		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			if (!player.inventory.hasItemStack(new ItemStack(AluminumUtility.OMAMORI, 1, 2))) {
				player.attackEntityFrom(DamageSource.GENERIC, Float.MAX_VALUE);
			}
		}else {
			entityIn.setDead();
		}
	}
}
