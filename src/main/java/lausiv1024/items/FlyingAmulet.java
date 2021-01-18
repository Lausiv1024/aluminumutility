package lausiv1024.items;

import lausiv1024.AluminumUtility;
import net.minecraft.item.Item;

public class FlyingAmulet extends Item {
	public FlyingAmulet() {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
		this.setRegistryName(AluminumUtility.MODID, "flying_amulet");
		this.setCreativeTab(AluminumUtility.alumiTab);
		this.setUnlocalizedName("flying_amulet");
		this.setMaxStackSize(1);
	}
}
