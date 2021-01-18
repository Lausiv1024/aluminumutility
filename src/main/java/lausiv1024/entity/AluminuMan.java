package lausiv1024.entity;

import java.util.Random;

import com.google.common.base.Predicate;

import lausiv1024.AluminumUtility;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AluminuMan extends EntityMob {
	public AluminuMan(World arg0) {
		super(arg0);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.8d));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2d, true));
		//this.tasks.addTask(3, new EntityAIMoveTowardsTarget(this, 1.2d, 50));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, false, true, new Predicate<EntityLiving>() {

			@Override
			public boolean apply(EntityLiving input) {
				if (input instanceof EntitySlime) {
					return true;
				}
				if (input instanceof EntityMagmaCube) {
					return true;
				}
				if (input instanceof EntityMob) {
					if (input instanceof AluminuMan) {
						return false;
					}
					return true;
				}
				return false;
			}
		}));
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}


	@Override
	public void onDeath(DamageSource cause) {
		Random random = new Random();
		int rr = random.nextInt(1000);
		if (this.isServerWorld()) {
			if (rr < 700) {
				entityDropItem(new ItemStack(AluminumUtility.ALUMINUM), 0.2f);
				//entityDropItem(new ItemStack(AluminumUtility.COMPRESSED_ALUMINUM, 256, 3), 0.2f);
			}else if (rr < 800) {
				entityDropItem(new ItemStack(AluminumUtility.COMPRESSED_ALUMINUM, 1, 0), 0.2f);
			}else if (rr < 900) {
				entityDropItem(new ItemStack(AluminumUtility.COMPRESSED_ALUMINUM, 1, 1), 0.2f);
			}else if (rr < 950) {
				entityDropItem(new ItemStack(AluminumUtility.COMPRESSED_ALUMINUM, 1, 2), 0.2f);
			}else if (rr < 980) {
				entityDropItem(new ItemStack(AluminumUtility.COMPRESSED_ALUMINUM, 1, 3), 0.2f);
			}else if (rr == 999) {
				entityDropItem(new ItemStack(AluminumUtility.COMPRESSED_ALUMINUM, 256, 3), 0.2f);
			}
		}
		super.onDeath(cause);
	}


	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(50);
	}

	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 15728880;
    }

    public float getBrightness(float p_70013_1_) {
        return 50.0F;
    }


    @Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (source.isExplosion()) {
			return false;
		}
		else if (source.isFireDamage()) {
			return false;
		}
		else if (source.isDamageAbsolute()) {
			return false;
		}
		else {
			return super.attackEntityFrom(source, damage);
		}
	}
}
