package net.mcreator.haegrilontest.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.haegrilontest.block.WattlecornerBlock;
import net.mcreator.haegrilontest.block.WattleBlock;
import net.mcreator.haegrilontest.HaegrilontestModElements;
import net.mcreator.haegrilontest.HaegrilontestMod;

import java.util.Map;

@HaegrilontestModElements.ModElement.Tag
public class WattleOnBlockRightClickedProcedure extends HaegrilontestModElements.ModElement {
	public WattleOnBlockRightClickedProcedure(HaegrilontestModElements instance) {
		super(instance, 538);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency entity for procedure WattleOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency x for procedure WattleOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency y for procedure WattleOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency z for procedure WattleOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency world for procedure WattleOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(WattleBlock.block, (int) (1)).getItem())) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = WattlecornerBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
