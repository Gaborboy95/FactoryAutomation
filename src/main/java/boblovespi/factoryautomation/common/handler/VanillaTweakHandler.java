package boblovespi.factoryautomation.common.handler;

import boblovespi.factoryautomation.common.config.SyncOnConfigChange;
import boblovespi.factoryautomation.common.config.SyncOnConfigChange.Priority;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import static boblovespi.factoryautomation.common.config.ConfigFields.blockMiningLevelCat;
import static boblovespi.factoryautomation.common.item.tools.ToolMaterials.*;

/**
 * Created by Willi on 4/30/2018.
 */
public class VanillaTweakHandler
{
	private static final String pick = "pickaxe";

	/*
		Harvest levels:
		0: wood
		1: stone
		2: copper
		3: iron
		4: bronze
		5: diamond / steel

		 */

	@SyncOnConfigChange(priority = Priority.FIRST)
	public static void TweakMiningLevels()
	{
		// temp
		Blocks.IRON_ORE.setHarvestLevel(pick, blockMiningLevelCat.ironOre);
		// temp

		Blocks.DIAMOND_ORE.setHarvestLevel(pick, blockMiningLevelCat.diamondOre);
		Blocks.REDSTONE_ORE.setHarvestLevel(pick, blockMiningLevelCat.redstoneOre);
		Blocks.LAPIS_ORE.setHarvestLevel(pick, blockMiningLevelCat.lapisOre);
		Blocks.GOLD_ORE.setHarvestLevel(pick, blockMiningLevelCat.goldOre);
		Blocks.LIT_REDSTONE_ORE.setHarvestLevel(pick, blockMiningLevelCat.redstoneOre);
		Blocks.OBSIDIAN.setHarvestLevel(pick, blockMiningLevelCat.obsidian);
	}

	@SyncOnConfigChange(priority = Priority.FIRST)
	public static void TweakToolLevels()
	{
		Items.IRON_PICKAXE.setHarvestLevel(pick, IRON);
		Items.DIAMOND_PICKAXE.setHarvestLevel(pick, DIAMOND);
		Items.GOLDEN_PICKAXE.setHarvestLevel(pick, COPPER);
		Items.STONE_PICKAXE.setHarvestLevel(pick, STONE);
		Items.WOODEN_PICKAXE.setHarvestLevel(pick, WOOD);

	}
}
