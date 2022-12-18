
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.haegrilontest.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class HaegrilontestModTabs {
	public static CreativeModeTab TAB_HAEGRILON;
	public static CreativeModeTab TAB_HAEGRILONPLANTS;
	public static CreativeModeTab TAB_HAEGRILONDECORATIVE;
	public static CreativeModeTab TAB_STONEBLOCKS;
	public static CreativeModeTab TAB_FOODANDCOOKINGITEMS;
	public static CreativeModeTab TAB_WOODANDTIMBER;
	public static CreativeModeTab TAB_ROOFING;
	public static CreativeModeTab TAB_PROFESSIONS;
	public static CreativeModeTab TAB_UTILITY;

	public static void load() {
		TAB_HAEGRILON = new CreativeModeTab("tabhaegrilon") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HaegrilontestModBlocks.WHITETIMBERCROSS.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_HAEGRILONPLANTS = new CreativeModeTab("tabhaegrilonplants") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.DARK_OAK_LEAVES);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_HAEGRILONDECORATIVE = new CreativeModeTab("tabhaegrilondecorative") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.TORCH);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_STONEBLOCKS = new CreativeModeTab("tabstoneblocks") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HaegrilontestModBlocks.SLATEBRICKS.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_FOODANDCOOKINGITEMS = new CreativeModeTab("tabfoodandcookingitems") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HaegrilontestModBlocks.MUTTON.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_WOODANDTIMBER = new CreativeModeTab("tabwoodandtimber") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HaegrilontestModBlocks.WHITEOAKTIMBEREAST.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_ROOFING = new CreativeModeTab("tabroofing") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HaegrilontestModBlocks.BLUESLATECORNER.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_PROFESSIONS = new CreativeModeTab("tabprofessions") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HaegrilontestModBlocks.CLEAVER.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_UTILITY = new CreativeModeTab("tabutility") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(HaegrilontestModBlocks.STATUSAPPROVED.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
