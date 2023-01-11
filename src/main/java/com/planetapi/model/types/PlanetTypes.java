package com.planetapi.model.types;

public class PlanetTypes {
    public enum ClimatesEnum {
        arid,
        tropical,
        dry,
        temperate,
        continental,
        polar,
        frozen
    }

    // TODO: map terrains to climates
    // TODO: map terrain subtypes to terrains
    public enum TerrainsEnum {
        desert,
        ice_cap,
        ice_caves,
        tundra,
        jungle,
        rainforests,
        forests,
        grasslands,
        mountains,
        mountain_ranges,
        lakes,
        swamp,
    }
}
