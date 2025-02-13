package com.gaussfff.graphenecomposite.core.components.block;

import com.gaussfff.graphenecomposite.core.components.block.functional.ChemicalReactorBlock;
import com.gaussfff.graphenecomposite.core.components.block.functional.CompressorBlock;
import com.gaussfff.graphenecomposite.core.components.block.functional.CrusherBlock;
import com.gaussfff.graphenecomposite.core.components.block.functional.FiltrationMachineBlock;
import com.gaussfff.graphenecomposite.core.components.block.natural.CarbonShaleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public enum Blocks {
    // functional blocks
    CRUSHER("crusher", CrusherBlock::new),
    CHEMICAL_REACTOR("chemical_reactor", ChemicalReactorBlock::new),
    FILTRATION_MACHINE("filtration_machine", FiltrationMachineBlock::new),
    COMPRESSOR("compressor", CompressorBlock::new),
    // natural blocks
    CARBON_SHALE("carbon_shale", CarbonShaleBlock::new);

    private final String id;
    private final Function<BlockBehaviour.Properties, Block> constructor;

    Blocks(String id, Function<BlockBehaviour.Properties, Block> constructor) {
        this.id = id;
        this.constructor = constructor;
    }

    public String getId() {
        return id;
    }

    public Function<BlockBehaviour.Properties, Block> getConstructor() {
        return constructor;
    }

    @Override
    public String toString() {
        return id;
    }
}
