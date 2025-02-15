package com.gaussfff.graphenecomposite.core.component.creative_tab;

import com.gaussfff.graphenecomposite.ModProps;
import net.minecraft.network.chat.Component;

public enum CreativeTabs {
    NATURAL_BLOCKS("natural_blocks"),
    FUNCTIONAL_BLOCKS("functional_blocks"),
    COMBAT("combat"),
    INGREDIENTS("ingredients");

    private String id;
    private Component title;

    CreativeTabs(String id) {
        this.id = id;
        this.title = Component.translatable(String.format("creativetab.%s.%s", ModProps.MOD_ID, id));
    }


    public String getId() {
        return id;
    }

    public Component getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id;
    }
}
