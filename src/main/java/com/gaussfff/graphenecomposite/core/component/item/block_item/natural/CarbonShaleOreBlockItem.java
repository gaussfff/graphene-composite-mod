package com.gaussfff.graphenecomposite.core.component.item.block_item.natural;

import com.gaussfff.graphenecomposite.core.component.block.Blocks;
import com.gaussfff.graphenecomposite.core.register.BlockRegister;
import net.minecraft.world.item.BlockItem;

public class CarbonShaleOreBlockItem extends BlockItem {

    public CarbonShaleOreBlockItem(Properties properties) {
        super(BlockRegister.getRegister().getBlock(Blocks.CARBON_SHALE_ORE).get(), properties);
    }
}
