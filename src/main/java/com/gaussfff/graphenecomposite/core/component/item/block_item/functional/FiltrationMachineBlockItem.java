package com.gaussfff.graphenecomposite.core.component.item.block_item.functional;

import com.gaussfff.graphenecomposite.core.component.block.Blocks;
import com.gaussfff.graphenecomposite.core.register.BlockRegister;
import net.minecraft.world.item.BlockItem;

public class FiltrationMachineBlockItem extends BlockItem {

    public FiltrationMachineBlockItem(Properties properties) {
        super(BlockRegister.getRegister().getBlock(Blocks.FILTRATION_MACHINE).get(), properties);
    }
}
