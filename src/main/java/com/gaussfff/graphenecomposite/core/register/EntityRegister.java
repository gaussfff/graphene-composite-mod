package com.gaussfff.graphenecomposite.core.register;

import com.gaussfff.graphenecomposite.ModProps;
import com.gaussfff.graphenecomposite.core.component.entity.Entities;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import com.mojang.logging.LogUtils;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public final class EntityRegister {

    private static EntityRegister register;

    private static final Logger LOGGER = LogUtils.getLogger();

    private final DeferredRegister<BlockEntityType<?>> entities;
    private final Map<Entities, DeferredHolder<?, ?>> entityRegister;

    public EntityRegister(IEventBus eventBus) {
        LOGGER.debug("entity register is loading...");

        this.entities = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ModProps.MOD_ID);
        this.entityRegister = new HashMap<>();

        this.entities.register(eventBus);

        LOGGER.debug("entity register was loaded");
    }

    private void register(Entities entity) {
        entityRegister.put(
                entity,
                entities.register(
                        entity.getId(),
                        new BlockEntityType<>(

                        )
                )
        );
        LOGGER.debug("entity {} was registered", entity);
    }

    public static EntityRegister getRegister(IEventBus eventBus) {
        synchronized (EntityRegister.class) {
            if (register == null) {
                register = new EntityRegister(eventBus);
            }
        }

        return register;
    }

    public static EntityRegister getRegister() {
        if (register == null) {
            throw new IllegalStateException("register wasn't inited");
        }

        return register;
    }
}
