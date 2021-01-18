package lausiv1024.entity;

import java.util.List;

import lausiv1024.AluminumUtility;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityChaosBall extends EntityThrowable {
	private int powerRange = 50;

	public EntityChaosBall(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public EntityChaosBall(World world) {
		super(world);
	}

	public EntityChaosBall(World world, int x, int y, int z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!world.isRemote)
		world.newExplosion(this, posX, posY, posZ, 250, false, true);
		setDead();
	}

	@Override
	public void onUpdate() {
		AxisAlignedBB range = new AxisAlignedBB(this.posX - powerRange, this.posY - powerRange, this.posZ - powerRange
				, this.posX + powerRange, this.posY + powerRange, this.posZ + powerRange);
		List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, range);
		for (Entity willDie : entityList) {
			if (willDie instanceof EntityLiving) {
				if (world.isRemote) {
					world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, willDie.posX, willDie.posY, willDie.posZ,
							0, 0, 0, 0);
				}
				willDie.setDead();
			}
			else if (willDie instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) willDie;
				if (!player.inventory.hasItemStack(new ItemStack(AluminumUtility.OMAMORI, 1, 2))) {
					player.attackEntityFrom(DamageSource.GENERIC, Float.MAX_VALUE);
				}
			}
		}
		super.onUpdate();
	}

}
