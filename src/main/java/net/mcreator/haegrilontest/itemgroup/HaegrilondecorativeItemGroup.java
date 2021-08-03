
package net.mcreator.haegrilontest.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class HaegrilondecorativeItemGroup extends HaegrilontestModElements.ModElement {
	public HaegrilondecorativeItemGroup(HaegrilontestModElements instance) {
		super(instance, 467);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabhaegrilondecorative") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.TORCH, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
