package lausiv1024.entity;

import lausiv1024.AluminumUtility;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityLausiv extends EntityMob {
	private boolean isPinch = false;
	private int exWaitTime = 0;

	private static final DataParameter<Integer> PINCH =
			EntityDataManager.<Integer>createKey(EntityLausiv.class,DataSerializers.VARINT);

	public EntityLausiv(World worldIn) {
		super(worldIn);
		if (this.getNavigator() instanceof PathNavigateGround) {
			PathNavigateGround navigateGround = (PathNavigateGround) this.getNavigator();
			navigateGround.setBreakDoors(true);
		}
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(2, new EntityAILausiv(this));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.2d, true));
		this.tasks.addTask(4, new EntityAIWander(this, 0.8d));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Double.MAX_VALUE);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(50);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.isEntityAlive()) {
			int state = getLausivState();
			if (this.getHealth() >= this.getMaxHealth() / 2) {
				isPinch = true;
			}
			else if (isPinch && this.getAttackTarget() != null) {
				exWaitTime++;

				if (exWaitTime >= 60) {
					setLausivState(0);
				}
				if (exWaitTime >= 100) {
					explosion();
					exWaitTime = 0;
					setLausivState(-1);
				}
			}
		}
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(PINCH, -1);
		super.entityInit();
	}

	@Override
	protected boolean canDespawn() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return 114514;
	}

	@Override
	public void onDeath(DamageSource cause) {
		dropItem(world, new ItemStack(AluminumUtility.ALUMINUM, 64), rand.nextInt(50) + 30);
		dropItem(world, new ItemStack(AluminumUtility.COMPRESSED_ALUMINUM, 64, 3), rand.nextInt(50) + 20);
		super.onDeath(cause);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		// TODO 自動生成されたメソッド・スタブ
		if (source.isExplosion()) {
			return false;
		}
		else if (source.isFireDamage()) {
			return false;
		}else if (source.isDamageAbsolute()) {
			return false;
		}
		return super.attackEntityFrom(source, amount);
	}

	private void explosion() {
		if (!this.world.isRemote) {
			this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3, false);
		}
	}

	public void setLausivState(int state) {
		this.dataManager.set(PINCH, state);
	}

	private void dropItem(World world, ItemStack stack, int count) {
		for (int i = 0; i < count; i++) {
			EntityItem eItem = new EntityItem(world, this.posX, this.posY, this.posZ, stack);
			eItem.setPosition(posX, posY, posZ);
			if (!world.isRemote) {
				world.spawnEntity(eItem);
			}
		}
	}

	public int getLausivState() {
		return this.dataManager.get(PINCH).intValue();
	}
}
