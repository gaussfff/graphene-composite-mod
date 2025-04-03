package com.gaussfff.graphenecomposite;

import com.gaussfff.graphenecomposite.core.register.BlockRegister;
import com.gaussfff.graphenecomposite.core.register.CreativeTabRegister;
import com.gaussfff.graphenecomposite.core.register.EntityRegister;
import com.gaussfff.graphenecomposite.core.register.ItemRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ModProps.MOD_ID)
public class ModStartup {

    private final ItemRegister itemRegister;
    private final BlockRegister blockRegister;
    private final CreativeTabRegister creativeTabRegister;
    private final EntityRegister entityRegister;

    public ModStartup(IEventBus eventBus) {
        // define registers here (ORDER IS IMPORTANT!)
        itemRegister = ItemRegister.getRegister(eventBus);
        blockRegister = BlockRegister.getRegister(eventBus);
        creativeTabRegister = CreativeTabRegister.getRegister(eventBus);
        entityRegister = EntityRegister
    }
}
