package com.gaussfff.graphenecomposite.core.datagen;

import com.gaussfff.graphenecomposite.ModProps;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

//@EventBusSubscriber(modid = ModProps.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {

    //@SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        //DataGenerator dataGenerator = event.getGenerator();
        //PackOutput packOutput = dataGenerator.getPackOutput();

        //event.addProvider(new ModBlockStateProvider());

        // TODO: implement me

    }
}
