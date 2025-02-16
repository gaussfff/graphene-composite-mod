package com.gaussfff.graphenecomposite.core.component.item.block_item.functional;

import com.gaussfff.graphenecomposite.core.component.block.Blocks;
import com.gaussfff.graphenecomposite.core.register.BlockRegister;
import net.minecraft.world.item.BlockItem;

public class ChemicalReactorBlockItem extends BlockItem {

    public ChemicalReactorBlockItem(Properties properties) {
        super(BlockRegister.getRegister().getBlock(Blocks.CHEMICAL_REACTOR).get(), properties);
    }
}
