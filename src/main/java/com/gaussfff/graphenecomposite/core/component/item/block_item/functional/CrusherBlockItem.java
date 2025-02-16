package com.gaussfff.graphenecomposite.core.component.item.block_item.functional;

import com.gaussfff.graphenecomposite.core.component.block.Blocks;
import com.gaussfff.graphenecomposite.core.register.BlockRegister;
import net.minecraft.world.item.BlockItem;

public class CrusherBlockItem extends BlockItem {

    public CrusherBlockItem(Properties properties) {
        super(BlockRegister.getRegister().getBlock(Blocks.CRUSHER).get(), properties);
    }
}
