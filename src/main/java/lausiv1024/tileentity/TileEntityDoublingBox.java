package lausiv1024.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDoublingBox extends TileEntity {
	private ItemStack kioku;

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		int aa = compound.getInteger("iitem");
		int meta = compound.getInteger("imeta");
		kioku = new ItemStack(Item.getItemById(aa), 1, meta);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		int aa = Item.getIdFromItem(kioku.getItem());
		compound.setInteger("iitem", aa);
		int meta = kioku.getMetadata();
		compound.setInteger("imeta", meta);
		return super.writeToNBT(compound);
	}
	public ItemStack getKioku() {
		return kioku;
	}
	public void setKioku(ItemStack kioku) {
		this.kioku = kioku;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
		this.writeToNBT(tagCompound);

		return new SPacketUpdateTileEntity(this.pos, 1, tagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}
}
