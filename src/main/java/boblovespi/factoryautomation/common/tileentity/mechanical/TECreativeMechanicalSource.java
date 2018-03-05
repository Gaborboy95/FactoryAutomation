package boblovespi.factoryautomation.common.tileentity.mechanical;

import boblovespi.factoryautomation.common.util.capability.IMechanicalUser;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

/**
 * Created by Willi on 2/20/2018.
 */
public class TECreativeMechanicalSource extends TileEntity
		implements IMechanicalUser
{
	private float torque;
	private float speed;

	@Override
	public boolean HasConnectionOnSide(EnumFacing side)
	{
		return true;
	}

	@Override
	public float GetSpeedOnFace(EnumFacing side)
	{
		return speed;
	}

	@Override
	public float GetTorqueOnFace(EnumFacing side)
	{
		return torque;
	}

	@Override
	public void SetSpeedOnFace(EnumFacing side, float speed)
	{

	}

	@Override
	public void SetTorqueOnFace(EnumFacing side, float torque)
	{

	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		speed = tag.getFloat("speed");
		torque = tag.getFloat("torque");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		tag.setFloat("speed", speed);
		tag.setFloat("torque", torque);
		return super.writeToNBT(tag);
	}
}
