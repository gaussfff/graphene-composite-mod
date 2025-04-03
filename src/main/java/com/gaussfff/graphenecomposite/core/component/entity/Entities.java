package com.gaussfff.graphenecomposite.core.component.entity;

import java.util.function.Function;

public enum Entities {
    CRUSHER("crusher"),
    CHEMICAL_REACTOR("chemical_reactor"),
    FILTRATION_MACHINE("filtration_machine"),
    COMPRESSOR("compressor");

    private final String id;
    private final Function<>

    Entities(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
