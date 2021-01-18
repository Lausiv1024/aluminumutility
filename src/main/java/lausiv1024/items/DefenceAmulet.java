package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DefenceAmulet extends Item {
	public DefenceAmulet() {
		super();
		this.setRegistryName(AluminumUtility.MODID, "defence_amulet");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("defence_amulet");
		this.setMaxStackSize(1);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			player.setHealth(player.getMaxHealth());
		}
	}
}
