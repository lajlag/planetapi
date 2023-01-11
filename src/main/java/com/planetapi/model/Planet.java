package com.planetapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.planetapi.model.types.PlanetTypes.ClimatesEnum;
import com.planetapi.model.types.PlanetTypes.TerrainsEnum;

@Entity
@EntityListeners(PlanetListener.class)
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
    private String climate;

    @Column(name = "terrain")
    private String terrain;

    @Column(name = "surfaceWater")
    private Integer surfaceWater;

    // public Planet(Long id, String name, Integer population, PlanetData
    // planetData) {
    public Planet(Long id, String name, Integer population,
            Integer rotationPeriod, Integer orbitalPeriod, Integer diameter, String gravity,
            String climate, String terrain, Integer surfaceWater) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.id = id;
        this.name = name;
        this.population = population;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.gravity = gravity;
        this.surfaceWater = surfaceWater;
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
        String[] climates = climate.split(",");
        List<String> validClimates = new ArrayList<String>();

        for (String c : climates) {
            String formattedClimate = c.trim().replace(" ", "_");
            for (ClimatesEnum climateEnum : ClimatesEnum.values()) {
                if (climateEnum.name().equals(formattedClimate)) {
                    validClimates.add(climateEnum.name());
                }
            }
        }
        String climateString = String.join(", ", validClimates);
        this.climate = climateString;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        String[] terrains = terrain.split(",");
        List<String> validTerrains = new ArrayList<String>();

        for (String t : terrains) {
            String formattedTerrain = t.trim().replace(" ", "_");
            for (TerrainsEnum terrainEnum : TerrainsEnum.values()) {
                if (terrainEnum.name().equals(formattedTerrain)) {
                    validTerrains.add(terrainEnum.name());
                }
            }
        }
        String terrainString = String.join(", ", validTerrains);
        this.terrain = terrainString;
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
}
