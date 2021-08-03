
package net.mcreator.haegrilontest.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class SwordofswordofallswordsItem extends HaegrilontestModElements.ModElement {
	@ObjectHolder("haegrilontest:swordofswordofallswords")
	public static final Item block = null;
	public SwordofswordofallswordsItem(HaegrilontestModElements instance) {
		super(instance, 510);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 9999;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 98605f;
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
		}, 3, -3f, new Item.Properties().group(null).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("swordofswordofallswords"));
	}
}
