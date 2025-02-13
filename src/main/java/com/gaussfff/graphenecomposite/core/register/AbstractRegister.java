package com.gaussfff.graphenecomposite.core.register;

import net.neoforged.bus.api.IEventBus;

public sealed abstract class AbstractRegister implements Register permits ItemRegister, BlockRegister {

    public AbstractRegister(IEventBus eventBus) {

    }
}
