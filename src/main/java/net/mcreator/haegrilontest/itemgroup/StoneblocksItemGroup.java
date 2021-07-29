
package net.mcreator.haegrilontest.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.haegrilontest.block.SlatebricksBlock;
import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class StoneblocksItemGroup extends HaegrilontestModElements.ModElement {
	public StoneblocksItemGroup(HaegrilontestModElements instance) {
		super(instance, 476);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabstoneblocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SlatebricksBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
