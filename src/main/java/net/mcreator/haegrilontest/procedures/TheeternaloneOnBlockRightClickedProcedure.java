package net.mcreator.haegrilontest.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;

import net.mcreator.haegrilontest.HaegrilontestModElements;
import net.mcreator.haegrilontest.HaegrilontestMod;

import java.util.Map;

@HaegrilontestModElements.ModElement.Tag
public class TheeternaloneOnBlockRightClickedProcedure extends HaegrilontestModElements.ModElement {
	public TheeternaloneOnBlockRightClickedProcedure(HaegrilontestModElements instance) {
		super(instance, 514);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency x for procedure TheeternaloneOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency y for procedure TheeternaloneOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency z for procedure TheeternaloneOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency world for procedure TheeternaloneOnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
			_ent.setEffectOnly(true);
			((World) world).addEntity(_ent);
		}
	}
}
