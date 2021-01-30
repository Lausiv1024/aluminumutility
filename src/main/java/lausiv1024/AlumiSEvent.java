package lausiv1024;

import java.util.Iterator;
import java.util.Random;

import lausiv1024.entity.EntityLausiv;
import lausiv1024.items.GodAmulet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AlumiSEvent {

	@SubscribeEvent
	public void jumpBoost(LivingJumpEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 0))) {
				player.motionY += 0.4f;
			}
		}
	}

	@SubscribeEvent
	public void playerAttacked(LivingAttackEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();

			if (event.getSource().getTrueSource() instanceof EntityLausiv) {
				if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 0)) || player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 2))) {
					Random random = new Random();
					int aaa = random.nextInt(100);
					if (aaa >= 90) {
						NonNullList<ItemStack> stacks = player.inventory.mainInventory;
						for (int i = 0;i < stacks.size(); i++) {

							if (stacks.get(i) != null) {
								if (stacks.get(i).getItem() == AluminumUtility.GOD_AMULET && (stacks.get(i).getItemDamage() == 0 || stacks.get(i).getItemDamage() == 2)) {
									if (!player.world.isRemote) {
										player.inventory.setInventorySlotContents(i, new ItemStack(AluminumUtility.GOD_AMULET, 1, 1));
									}
								}
							}

						}
					}
					event.setCanceled(true);
				}else if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.DEFENCE_AMULET))) {
					player.inventory.clearMatchingItems(AluminumUtility.DEFENCE_AMULET, 0, 1, null);
				}else if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 1))) {
					Random random = new Random();
					int aaa = random.nextInt(100);
					if (aaa >= 50) {
						player.inventory.clearMatchingItems(AluminumUtility.GOD_AMULET, 1, 1, null);
						player.world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ZOMBIE_BREAK_DOOR_WOOD, SoundCategory.NEUTRAL, 0.5f, 0.5f);
					}
					event.setCanceled(true);
				}
			}

			if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.DEFENCE_AMULET)) ||
					player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 0)) || player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 2))) {
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void detoNate(ExplosionEvent.Detonate event) {
		if (event.getExplosion().getExplosivePlacedBy() != null
				&& event.getExplosion().getExplosivePlacedBy() instanceof EntityLausiv) {

			Iterator<Entity> higaisha = event.getAffectedEntities().iterator();

			while (higaisha.hasNext()) {
				Entity entity = (Entity) higaisha.next();

				if (entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) entity;

					if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.DEFENCE_AMULET))) {
						player.inventory.deleteStack(new ItemStack(AluminumUtility.DEFENCE_AMULET));
					}else if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 0)) || player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 2))) {

						NonNullList<ItemStack> stacks = player.inventory.mainInventory;

						for (int i = 0;i < stacks.size(); i++) {

							if (stacks.get(i) != null && stacks.get(i).getItem() instanceof GodAmulet &&
									stacks.get(i).getItemDamage() == 0) {
								player.inventory.setInventorySlotContents(i, new ItemStack(AluminumUtility.GOD_AMULET, 1, 1));
							}

						}

					}else if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 1))) {
						player.inventory.deleteStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 1));
					}


				}

			}
		}
	}

	@SubscribeEvent
	public void onEndraDeath(LivingDeathEvent event) {
		if (event.getEntityLiving() instanceof EntityDragon) {
			if (!event.getEntityLiving().getEntityWorld().isRemote)
			event.getEntityLiving().getEntityWorld().setBlockState(new BlockPos(0, 75, 0)
					,AluminumUtility.LAUSIV_BLOCK.getDefaultState());
			//event.getEntityLiving().getEntityWorld().setBlockState(new BlockPos(event.getEntityLiving()), AluminumUtility.LAUSIV_BLOCK.getDefaultState());
		}
	}

	@SubscribeEvent
	public void playerUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 0)) ||
					player.inventory.hasItemStack(new ItemStack(AluminumUtility.FLYING_AMULET)) || player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 2))) {
				player.capabilities.allowFlying = true;
				if (player.isSprinting() && player.moveForward > 0f && (player.inventory.hasItemStack(
						new ItemStack(AluminumUtility.GOD_AMULET, 1, 0)) || player.inventory.hasItemStack(new ItemStack(AluminumUtility.GOD_AMULET, 1, 2)))) {
					player.capabilities.setFlySpeed(0.2f);
				}else {
					player.capabilities.setFlySpeed(0.05f);
				}
			}else {
				if (!player.capabilities.isCreativeMode) {
					player.capabilities.allowFlying = false;
					player.capabilities.isFlying = false;
					player.capabilities.setFlySpeed(0.05f);
				}
			}
		}
	}
}
