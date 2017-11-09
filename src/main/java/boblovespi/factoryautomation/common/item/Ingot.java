package boblovespi.factoryautomation.common.item;

import boblovespi.factoryautomation.common.item.types.Metals;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Willi on 11/9/2017.
 */
public class Ingot extends MultiTypeItem<Metals>
		implements FAItem, IMultiVariantItem
{
	public Ingot()
	{
		super("ingot", CreativeTabs.MATERIALS);
	}

	@Override
	public String UnlocalizedName()
	{
		return "ingot";
	}

	@Override
	public String GetMetaFilePath(int meta)
	{
		return null;
	}

	@Override
	public Item ToItem()
	{
		return this;
	}
}
