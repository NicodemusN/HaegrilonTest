
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.haegrilontest.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.decoration.Motive;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HaegrilontestModPaintings {
	@SubscribeEvent
	public static void registerMotives(RegistryEvent.Register<Motive> event) {
		event.getRegistry().register(new Motive(64, 64).setRegistryName("tapestry"));
		event.getRegistry().register(new Motive(64, 64).setRegistryName("tapestry_2"));
		event.getRegistry().register(new Motive(32, 32).setRegistryName("thelord"));
		event.getRegistry().register(new Motive(32, 32).setRegistryName("brutality"));
	}
}
