package com.gaussfff.graphenecomposite.core.register;

import com.gaussfff.graphenecomposite.ModProps;
import com.gaussfff.graphenecomposite.core.component.block.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
import net.minecraft.core.Holder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.gaussfff.graphenecomposite.core.component.block.Blocks.*;

public final class BlockRegister {

    private static BlockRegister register;

    private static final Logger LOGGER = LogUtils.getLogger();

    private final DeferredRegister.Blocks blocks;
    private final Map<Blocks, DeferredBlock<? extends Block>> blockRegister;

    public BlockRegister(IEventBus eventBus) {
        LOGGER.debug("block register is loading...");

        this.blocks = DeferredRegister.createBlocks(ModProps.MOD_ID);
        this.blockRegister = new HashMap<>();

        this.blocks.register(eventBus);

        // register functional blocks
        register(CRUSHER);
        register(CARBON_SHALE_ORE);
        register(CHEMICAL_REACTOR);
        register(FILTRATION_MACHINE);
        register(COMPRESSOR);

        // register natural blocks
        register(CARBON_SHALE_ORE);

        LOGGER.debug("block register was loaded");
    }

    private void register(Blocks block) {
        blockRegister.put(
                block,
                blocks.register(
                        block.getId(),
                        (registryName) -> block.getConstructor().apply(
                                BlockBehaviour.Properties.of()
                                        .setId(ResourceKey.create(Registries.BLOCK, registryName))
                        )
                )
        );
        LOGGER.debug(String.format("block %s was registered", block));
    }

    public Iterable<Block> getBlockIteratorFn() {
        return blocks.getEntries().stream().map(Holder::value)::iterator;
    }

    public DeferredBlock<? extends Block> getBlock(Blocks block) {
        return Optional.of(blockRegister.get(block)).orElseThrow(() -> new IllegalArgumentException(String.format("block %s doesn't exist", block)));
    }

    public static BlockRegister getRegister(IEventBus eventBus) {
        synchronized (BlockRegister.class) {
            if (register == null) {
                register = new BlockRegister(eventBus);
            }
        }

        return register;
    }

    public static BlockRegister getRegister() {
        if (register == null) {
            throw new IllegalStateException("register wasn't inited");
        }

        return register;
    }
}
