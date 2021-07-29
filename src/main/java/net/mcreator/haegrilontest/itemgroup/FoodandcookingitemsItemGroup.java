
package net.mcreator.haegrilontest.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.haegrilontest.block.MuttonBlock;
import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class FoodandcookingitemsItemGroup extends HaegrilontestModElements.ModElement {
	public FoodandcookingitemsItemGroup(HaegrilontestModElements instance) {
		super(instance, 477);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabfoodandcookingitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MuttonBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
