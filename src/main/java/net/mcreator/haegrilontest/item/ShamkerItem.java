
package net.mcreator.haegrilontest.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.haegrilontest.itemgroup.HaegrilondecorativeItemGroup;
import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class ShamkerItem extends HaegrilontestModElements.ModElement {
	@ObjectHolder("haegrilontest:shamker")
	public static final Item block = null;
	public ShamkerItem(HaegrilontestModElements instance) {
		super(instance, 333);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 97f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(HaegrilondecorativeItemGroup.tab)) {
		}.setRegistryName("shamker"));
	}
}
