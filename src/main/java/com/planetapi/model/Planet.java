package com.planetapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "population")
    private Integer population;

    @Column(name = "rotationPeriod")
    private Integer rotationPeriod;

    @Column(name = "orbitalPeriod")
    private Integer orbitalPeriod;

    @Column(name = "diameter")
    private Integer diameter;

    @Column(name = "gravity")
    private String gravity;

    @Column(name = "climate")
    // @Enumerated(EnumType.STRING)
    private String climate;

    @Column(name = "terrain")
    private String terrain;

    // percentage maybe?
    @Column(name = "surfaceWater")
    private Integer surfaceWater;

    public enum Climates {
        tropical,
        dry,
        temperate,
        continental,
        polar,
    }

    // TODO: map terrains to climates
    // TODO: map terrain subtypes to terrains
    protected enum Terrains {
        desert,
        ice_cap,
        tundra,
        rainforests,
        forests,
        grasslands,
        mountains,
        lakes,
        swamp,
    }

    public Planet() {
    }

    // public Planet(Long id, String name, Integer population, PlanetData
    // planetData) {
    public Planet(Long id, String name, Integer population,
            Integer rotation_period, Integer orbital_period, Integer diameter, String gravity,
            String climate, String terrain, Integer surface_water) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.id = id;
        this.name = name;
        this.population = population;
        this.rotationPeriod = rotation_period;
        this.orbitalPeriod = orbital_period;
        this.diameter = diameter;
        this.gravity = gravity;
        this.surfaceWater = surface_water;
        this.climate = climate;
        this.terrain = terrain;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Integer rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public Integer getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Integer orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public Integer getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(Integer surfaceWater) {
        this.surfaceWater = surfaceWater;
    }
    // public void setPlanetData(PlanetData planetData) {
    // }

    // public PlanetData getPlanetData() {
    // return planetData;
    // }

    // @Override
    // public String toString() {
    // return "Planet [id=" + id + ", name=" + name + ", population=" + population +
    // "]";
    // }
}
