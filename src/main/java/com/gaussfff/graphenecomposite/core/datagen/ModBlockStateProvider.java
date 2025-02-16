package com.gaussfff.graphenecomposite.core.datagen;

import net.minecraft.core.BlockPos;
import net.minecraft.data.PackOutput;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFile)

    @Override
    protected BlockStateProviderType<?> type() {
        return null;
    }

    @Override
    public BlockState getState(RandomSource random, BlockPos pos) {
        return null;
    }
}
