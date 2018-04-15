package boblovespi.factoryautomation.common.util;

import boblovespi.factoryautomation.common.item.FAItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Created by Willi on 4/8/2018.
 */
public class FACreativeTabs
{
	public static CreativeTabs metallurgy = new CreativeTabs(
			"tabs.metallurgy.name")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(FAItems.clayCrucible.ToItem());
		}

	};
	public static CreativeTabs resources = new CreativeTabs(
			"tabs.resources.name")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(FAItems.diamondGravel.ToItem());
		}
	};
}