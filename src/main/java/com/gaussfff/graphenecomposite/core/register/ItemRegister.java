package com.gaussfff.graphenecomposite.core.register;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public final class ItemRegister extends AbstractRegister {

    private static ItemRegister register;

    private ItemRegister(IEventBus eventBus) {
        super(eventBus);
    }

    @Override
    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        // TODO: implement me
    }

    public static ItemRegister getRegister(IEventBus eventBus) {
        synchronized (ItemRegister.class) {
            if (register == null) {
                register = new ItemRegister(eventBus);
            }
        }

        return register;
    }

    public static ItemRegister getRegister() {
        if (register == null) {
            throw new IllegalStateException("register is not inited");
        }

        return register;
    }
}
