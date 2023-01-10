package com.planetapi.model.types;

public class PlanetData {
    protected enum Climates {
        temperate, tropical
    }

    protected enum Terrains {
        jungle, rainforests
    }

    protected int rotation_period;
    protected int orbital_period;
    protected int diameter;
    // Climate should be some enum
    protected Climates[] climate;
    protected Terrains[] terrain;
    protected String gravity;
    // percentage maybe?
    protected int surface_water;

    public int getRotationPeriod() {
        return rotation_period;
    }

    public int getOrbitalPeriod() {
        return orbital_period;
    }

    public int getDiameter() {
        return diameter;
    }

    public Climates[] getClimate() {
        return climate;
    }

    public Terrains[] getTerrain() {
        return terrain;
    }

    public String getGravity() {
        return gravity;
    }

    public int getSurfaceWater() {
        return surface_water;
    }

    // // "rotation_period": "24",
    // // "orbital_period": "4818",
    // // "diameter": "10200",
    // // "climate": "temperate, tropical",
    // // "gravity": "1 standard",
    // // "terrain": "jungle, rainforests",
    // // "surface_water": "8",
    // // "population": "1000",

}
