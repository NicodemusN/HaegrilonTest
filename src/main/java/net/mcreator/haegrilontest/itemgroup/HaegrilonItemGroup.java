
package net.mcreator.haegrilontest.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.haegrilontest.block.WhitetimbercrossBlock;
import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class HaegrilonItemGroup extends HaegrilontestModElements.ModElement {
	public HaegrilonItemGroup(HaegrilontestModElements instance) {
		super(instance, 394);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabhaegrilon") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(WhitetimbercrossBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
