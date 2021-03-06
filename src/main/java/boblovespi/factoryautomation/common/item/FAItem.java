package boblovespi.factoryautomation.common.item;

import net.minecraft.item.Item;

import java.util.function.Consumer;

/**
 * Created by Willi on 4/12/2017.
 * the default interface for all factory automation items.  every item MUST implement this
 */
public interface FAItem
{
	String UnlocalizedName();

	default String RegistryName()
	{
		return UnlocalizedName();
	}

	String GetMetaFilePath(int meta);

	Item ToItem();

	default FAItem Init(Consumer<Item> apply)
	{
		apply.accept(this.ToItem());
		return this;
	}
}
