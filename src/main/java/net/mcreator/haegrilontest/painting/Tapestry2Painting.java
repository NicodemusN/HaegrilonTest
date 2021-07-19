
package net.mcreator.haegrilontest.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.haegrilontest.HaegrilontestModElements;

@HaegrilontestModElements.ModElement.Tag
public class Tapestry2Painting extends HaegrilontestModElements.ModElement {
	public Tapestry2Painting(HaegrilontestModElements instance) {
		super(instance, 398);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("tapestry_2"));
	}
}
