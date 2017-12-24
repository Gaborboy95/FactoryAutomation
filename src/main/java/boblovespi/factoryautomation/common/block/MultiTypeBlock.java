package boblovespi.factoryautomation.common.block;

import boblovespi.factoryautomation.common.item.FAItems;
import boblovespi.factoryautomation.common.item.MultiTypeItemBlock;
import boblovespi.factoryautomation.common.item.types.IMultiTypeEnum;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Willi on 12/23/2017.
 */
public class MultiTypeBlock<T extends Enum<T> & IMultiTypeEnum & IStringSerializable>
		extends Block implements FABlock
{
	protected final Class<T> blockTypes;
	private final String unlocalizedName;
	public /*final*/ PropertyEnum<T> TYPE;
	private String resourceFolder;

	public MultiTypeBlock(Material blockMaterialIn, MapColor blockMapColorIn,
			String unlocalizedName, Class<T> types, String resourceFolder)
	{
		super(blockMaterialIn, blockMapColorIn);
		this.unlocalizedName = unlocalizedName;
		blockTypes = types;

		this.resourceFolder = resourceFolder;
		TYPE = PropertyEnum.create("type", types);
		setDefaultState(blockState.getBaseState().withProperty(TYPE, blockTypes
				.getEnumConstants()[0]));
		setUnlocalizedName(UnlocalizedName());
		setRegistryName(RegistryName());
		FABlocks.blocks.add(this);
		FAItems.items.add(new MultiTypeItemBlock<T>(this, types));
	}

	public MultiTypeBlock(Material materialIn, String unlocalizedName,
			Class<T> types, String resourceFolder)
	{
		this(materialIn, materialIn.getMaterialMapColor(), unlocalizedName,
			 types, resourceFolder);
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for (int i = 0; i < blockTypes.getEnumConstants().length; i++)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState()
				.withProperty(TYPE, blockTypes.getEnumConstants()[meta]);
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(TYPE).GetId();
	}

	@Override
	public String UnlocalizedName()
	{
		return unlocalizedName;
	}

	@Override
	public String GetMetaFilePath(int meta)
	{
		String folder = (resourceFolder == null || resourceFolder.isEmpty()) ?
				"" :
				resourceFolder + "/";

		T[] types = blockTypes.getEnumConstants();

		for (int i = 0; i < types.length; i++)
			if (meta == i)
				return folder + UnlocalizedName() + "_" + types[i].getName();

		return folder + UnlocalizedName() + "_" + types[0].getName();
	}

	@Override
	public Block ToBlock()
	{
		return this;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, TYPE);
	}

	/**
	 * Gets the {@link IBlockState} to place
	 *
	 * @param world  The world the block is being placed in
	 * @param pos    The position the block is being placed at
	 * @param facing The side the block is being placed on
	 * @param hitX   The X coordinate of the hit vector
	 * @param hitY   The Y coordinate of the hit vector
	 * @param hitZ   The Z coordinate of the hit vector
	 * @param meta   The metadata of {@link ItemStack} as processed by {@link Item#getMetadata(int)}
	 * @param placer The entity placing the block
	 * @param hand   The player hand used to place this block
	 * @return The state to be placed in the world
	 */
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos,
			EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
			EntityLivingBase placer, EnumHand hand)
	{
		return getStateFromMeta(meta);
	}
}