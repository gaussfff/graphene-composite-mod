package com.gaussfff.graphenecomposite.core.component.block.natural;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;

public class CarbonShaleOreBlock extends DropExperienceBlock {

    public CarbonShaleOreBlock(Properties properties) {
        super(
                UniformInt.of(2, 4),
                properties
                        .strength(3f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)
        );
    }
}
