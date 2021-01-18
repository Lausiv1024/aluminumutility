package lausiv1024.tileentity;

import lausiv1024.blocks.DaylightControllerNight;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;

public class TileEntityDaylightControllerNight extends TileEntity implements ITickable {

	@Override
	public void update() {
		if (world != null) {
			if (!world.isRemote) {
				blockType = getBlockType();
				if (blockType instanceof DaylightControllerNight) {
					TIMESet(world);
				}
			}
		}
	}
	private void TIMESet(World world) {
		long worldTime = world.getWorldTime();
		long date = (long) Math.floor(worldTime / 24000);
		long curticktime = worldTime - date * 24000;
		if (curticktime >= 22550 || curticktime <= 13050) {
			world.setWorldTime(13051 + 24000 * (date + 1));
		}
	}

}
