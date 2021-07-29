package net.mcreator.haegrilontest.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;

import net.mcreator.haegrilontest.block.SpruceshuttermiddleopenBlock;
import net.mcreator.haegrilontest.HaegrilontestModElements;
import net.mcreator.haegrilontest.HaegrilontestMod;

import java.util.Map;

@HaegrilontestModElements.ModElement.Tag
public class ShuttermotionmiddleSProcedure extends HaegrilontestModElements.ModElement {
	public ShuttermotionmiddleSProcedure(HaegrilontestModElements instance) {
		super(instance, 452);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency x for procedure ShuttermotionmiddleS!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency y for procedure ShuttermotionmiddleS!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency z for procedure ShuttermotionmiddleS!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency world for procedure ShuttermotionmiddleS!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = SpruceshuttermiddleopenBlock.block.getDefaultState();
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
