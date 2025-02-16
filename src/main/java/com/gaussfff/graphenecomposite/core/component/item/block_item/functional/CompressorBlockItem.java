package com.gaussfff.graphenecomposite.core.component.item.block_item.functional;

import com.gaussfff.graphenecomposite.core.component.block.Blocks;
import com.gaussfff.graphenecomposite.core.register.BlockRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class CompressorBlockItem extends BlockItem {

    public CompressorBlockItem(Properties properties) {
        super(BlockRegister.getRegister().getBlock(Blocks.COMPRESSOR).get(), properties);
    }
}
