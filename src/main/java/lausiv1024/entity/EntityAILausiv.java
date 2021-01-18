package lausiv1024.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAILausiv extends EntityAIBase {
	EntityLausiv lausiv;
	EntityLivingBase lausivAttackTarget;

	public EntityAILausiv(EntityLausiv lausiv) {
		this.lausiv = lausiv;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean shouldExecute() {
		// TODO 自動生成されたメソッド・スタブ
		return this.lausiv.getLausivState() >= 0;
	}

	@Override
	public void startExecuting() {
		lausivAttackTarget = lausiv.getAttackTarget();
		super.startExecuting();
	}

	@Override
	public void resetTask() {
		lausivAttackTarget = null;
		super.resetTask();
	}

	@Override
	public void updateTask() {
		if (lausivAttackTarget == null) {
			lausiv.setLausivState(-1);
		}
	}
}
