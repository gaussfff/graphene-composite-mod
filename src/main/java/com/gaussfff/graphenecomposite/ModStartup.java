package com.gaussfff.graphenecomposite;

import com.gaussfff.graphenecomposite.core.register.BlockRegister;
import com.gaussfff.graphenecomposite.core.register.ItemRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(ModProps.MODID)
public class ModStartup {

    private final ItemRegister itemRegister;
    private final BlockRegister blockRegister;

    public ModStartup(IEventBus eventBus) {
        // define registers here (ORDER IS IMPORTANT!)
        itemRegister = ItemRegister.getRegister(eventBus);
        blockRegister = BlockRegister.getRegister(eventBus);

        // register events here
        eventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        itemRegister.addCreative(event);
        blockRegister.addCreative(event);
    }
}
