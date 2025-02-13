package com.gaussfff.graphenecomposite.core.register;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public final class CreativeTabRegister extends AbstractRegister {

    public CreativeTabRegister(IEventBus eventBus) {
        super(eventBus);
    }

    @Override
    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        throw new UnsupportedOperationException();
    }
}
