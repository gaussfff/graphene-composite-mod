package com.gaussfff.graphenecomposite.core.register;

import com.gaussfff.graphenecomposite.ModProps;
import com.gaussfff.graphenecomposite.core.component.block.Blocks;
import com.gaussfff.graphenecomposite.core.component.creative_tab.CreativeTabs;
import com.gaussfff.graphenecomposite.core.component.item.Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import com.mojang.logging.LogUtils;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static com.gaussfff.graphenecomposite.core.component.creative_tab.CreativeTabs.*;

public final class CreativeTabRegister {

    private static CreativeTabRegister register;

    private static final Logger LOGGER = LogUtils.getLogger();

    private final DeferredRegister<CreativeModeTab> creativeTabs;
    private final Map<CreativeTabs, DeferredHolder<?, ?>> creativeTabsRegister;

    private final ItemRegister itemRegister;
    private final BlockRegister blockRegister;

    private CreativeTabRegister(IEventBus eventBus) {
        LOGGER.debug("creative tabs register is loading...");

        this.creativeTabs = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModProps.MOD_ID);
        this.creativeTabsRegister = new HashMap<>();

        this.itemRegister = ItemRegister.getRegister();
        this.blockRegister = BlockRegister.getRegister();

        this.creativeTabs.register(eventBus);

        creativeTabsRegister.put(
                NATURAL_BLOCKS,
                creativeTabs.register(
                        NATURAL_BLOCKS.getId(),
                        () -> CreativeModeTab.builder().icon(() -> new ItemStack(blockRegister.getBlock(Blocks.CARBON_SHALE_ORE).get()))
                                .title(NATURAL_BLOCKS.getTitle())
                                .displayItems((itemDisplayParameters, output) -> {
                                    output.accept(blockRegister.getBlock(Blocks.CARBON_SHALE_ORE));
                                }).build()
                )
        );
        logCreativeTabRegistered(NATURAL_BLOCKS);


        creativeTabsRegister.put(
                FUNCTIONAL_BLOCKS,
                creativeTabs.register(
                        FUNCTIONAL_BLOCKS.getId(),
                        () -> CreativeModeTab.builder().icon(() -> new ItemStack(blockRegister.getBlock(Blocks.CHEMICAL_REACTOR).get()))
                                .title(FUNCTIONAL_BLOCKS.getTitle())
                                .withTabsAfter(ResourceLocation.fromNamespaceAndPath(ModProps.MOD_ID, NATURAL_BLOCKS.getId()))
                                .displayItems((itemDisplayParameters, output) -> {
                                    output.accept(blockRegister.getBlock(Blocks.CRUSHER));
                                    output.accept(blockRegister.getBlock(Blocks.CHEMICAL_REACTOR));
                                    output.accept(blockRegister.getBlock(Blocks.FILTRATION_MACHINE));
                                    output.accept(blockRegister.getBlock(Blocks.COMPRESSOR));
                                }).build()
                )
        );
        logCreativeTabRegistered(FUNCTIONAL_BLOCKS);

        creativeTabsRegister.put(
                COMBAT,
                creativeTabs.register(
                        COMBAT.getId(),
                        () -> CreativeModeTab.builder().icon(() -> new ItemStack(itemRegister.getItem(Items.GRAPHENE_SWORD).get()))
                                .title(COMBAT.getTitle())
                                .withTabsAfter(ResourceLocation.fromNamespaceAndPath(ModProps.MOD_ID, FUNCTIONAL_BLOCKS.getId()))
                                .displayItems((itemDisplayParameters, output) -> {
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_BOOTS));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_HELMET));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_CHESTPLATE));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_LEGGINGS));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_SWORD));
                                }).build()
                )
        );
        logCreativeTabRegistered(COMBAT);

        creativeTabsRegister.put(
                INGREDIENTS,
                creativeTabs.register(
                        INGREDIENTS.getId(),
                        () -> CreativeModeTab.builder().icon(() -> new ItemStack(itemRegister.getItem(Items.GRAPHENE_COMPOSITE).get()))
                                .title(INGREDIENTS.getTitle())
                                .withTabsAfter(ResourceLocation.fromNamespaceAndPath(ModProps.MOD_ID, INGREDIENTS.getId()))
                                .displayItems((itemDisplayParameters, output) -> {
                                    output.accept(itemRegister.getItem(Items.GRAPHITE));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_PLATE));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_COMPOSITE));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_SUSPENSION));
                                    output.accept(itemRegister.getItem(Items.GRAPHENE_COMPOSITE_BLANK));
                                    output.accept(itemRegister.getItem(Items.COAL_DUST));
                                    output.accept(itemRegister.getItem(Items.LIQUID_CARBON_BUCKET));
                                    output.accept(itemRegister.getItem(Items.POLYMER_THREAD));
                                    output.accept(itemRegister.getItem(Items.TREE_BARK));
                                    output.accept(itemRegister.getItem(Items.TREE_RESIN));
                                    output.accept(itemRegister.getItem(Items.MECHANISM));
                                }).build()
                )
        );
        logCreativeTabRegistered(INGREDIENTS);

        LOGGER.debug("creative tabs register was loaded");
    }

    private void logCreativeTabRegistered(CreativeTabs creativeTab) {
        LOGGER.debug("creative tab {} was registered", creativeTab);
    }

    public static CreativeTabRegister getRegister(IEventBus eventBus) {
        synchronized (CreativeTabRegister.class) {
            if (register == null) {
                register = new CreativeTabRegister(eventBus);
            }
        }

        return register;
    }

    public static CreativeTabRegister getRegister() {
        if (register == null) {
            throw new IllegalStateException("register wasn't inited");
        }

        return register;
    }
}
