package com.gaussfff.graphenecomposite.core.register;

import com.gaussfff.graphenecomposite.ModProps;
import com.gaussfff.graphenecomposite.core.component.item.Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import com.mojang.logging.LogUtils;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.gaussfff.graphenecomposite.core.component.item.Items.*;

public final class ItemRegister {

    private static ItemRegister registerInstance;

    private static final Logger LOGGER = LogUtils.getLogger();

    private final DeferredRegister.Items items;
    private final Map<Items, DeferredItem<? extends Item>> itemRegister;

    private ItemRegister(IEventBus eventBus) {
        LOGGER.debug("item register is loading...");

        this.items = DeferredRegister.createItems(ModProps.MOD_ID);
        this.itemRegister = new HashMap<>();

        this.items.register(eventBus);
        
        // combat items
        register(GRAPHENE_BOOTS);
        register(GRAPHENE_HELMET);
        register(GRAPHENE_CHESTPLATE);
        register(GRAPHENE_LEGGINGS);
        register(GRAPHENE_SWORD);
        
        // ingredients items
        register(GRAPHITE);
        register(GRAPHENE);
        register(GRAPHENE_PLATE);
        register(GRAPHENE_COMPOSITE);
        register(GRAPHENE_SUSPENSION);
        register(GRAPHENE_COMPOSITE_BLANK);
        register(COAL_DUST);
        register(LIQUID_CARBON_BUCKET);
        register(POLYMER_THREAD);
        register(TREE_BARK);
        register(TREE_RESIN);
        register(MECHANISM);

        LOGGER.debug("item register was loaded");
    }

    private void register(Items item) {
        itemRegister.put(
                item,
                items.register(
                        item.getId(),
                        (registryName) -> item.getConstructor().apply(
                                new Item.Properties()
                                        .setId(ResourceKey.create(Registries.ITEM, registryName))
                        )
                )
        );
        LOGGER.debug(String.format("item %s was registered", item));
    }

    public DeferredItem<? extends Item> getItem(Items item) {
        return Optional.of(itemRegister.get(item)).orElseThrow(() -> new IllegalArgumentException(String.format("item %s doesn't exist", item)));
    }

    public static ItemRegister getRegister(IEventBus eventBus) {
        synchronized (ItemRegister.class) {
            if (registerInstance == null) {
                registerInstance = new ItemRegister(eventBus);
            }
        }

        return registerInstance;
    }

    public static ItemRegister getRegister() {
        if (registerInstance == null) {
            throw new IllegalStateException("register wasn't inited");
        }

        return registerInstance;
    }
}
