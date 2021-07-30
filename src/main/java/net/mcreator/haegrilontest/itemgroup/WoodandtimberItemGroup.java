
package net.mcreator.haegrilontest.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.haegrilontest.block.WhiteoaktimbereastBlock;
import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class WoodandtimberItemGroup extends HaegrilontestModElements.ModElement {
	public WoodandtimberItemGroup(HaegrilontestModElements instance) {
		super(instance, 484);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwoodandtimber") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(WhiteoaktimbereastBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
