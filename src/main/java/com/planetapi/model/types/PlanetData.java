package com.planetapi.model.types;

public class PlanetData {
    public enum Climates {
        temperate, tropical
    }

    public enum Terrains {
        jungle, rainforests
    }

    public int rotation_period;
    public int orbital_period;
    public int diameter;
    // Climate should be some enum
    public Climates[] climate;
    public Terrains[] terrain;
    public String gravity;
    // percentage maybe?
    public int surface_water;
    public String eye_color;

    public int getRotationPeriod() {
        return rotation_period;
    }

}
