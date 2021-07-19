package net.mcreator.haegrilontest.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.haegrilontest.HaegrilontestModElements;
import net.mcreator.haegrilontest.HaegrilontestMod;

import java.util.Map;

@HaegrilontestModElements.ModElement.Tag
public class GuestflyCommandExecutedProcedure extends HaegrilontestModElements.ModElement {
	public GuestflyCommandExecutedProcedure(HaegrilontestModElements instance) {
		super(instance, 443);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HaegrilontestMod.LOGGER.warn("Failed to load dependency entity for procedure GuestflyCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.allowFlying = (true);
			((PlayerEntity) entity).sendPlayerAbilities();
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You can fly now!"), (false));
		}
	}
}
