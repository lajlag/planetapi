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
public class Planet implements CelestialBodyInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "population")
    private String population;

    @Column(name = "rotationPeriod")
    private Long rotationPeriod;

    @Column(name = "orbitalPeriod")
    private Long orbitalPeriod;

    @Column(name = "diameter")
    private Long diameter;

    @Column(name = "gravity")
    private String gravity;

    @Column(name = "climate")
    private String climate;

    @Column(name = "terrain")
    private String terrain;

    @Column(name = "surfaceWater")
    private String surfaceWater;

    @Column(name = "surfaceArea")
    private Double surfaceArea;

    public Planet() {
    }

    public Planet(long diameter) {
        this.diameter = diameter;
        this.surfaceArea = calculateSurfaceArea(diameter);
    }

    // TODO: planet data details should be abstracted to a separate class
    // and saved as a Jsonb object in db
    public Planet(Long id, String name, String population,
            Long rotationPeriod, Long orbitalPeriod, Long diameter, String gravity,
            String climate, String terrain, String surfaceWater, Double surfaceArea) {
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

    public String getPopulation() {
        return population;
    }

    public Long getRotationPeriod() {
        return rotationPeriod;
    }

    public Long getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Long getDiameter() {
        return diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setRotationPeriod(Long rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public void setOrbitalPeriod(Long orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    // TODO: this method and setTerrain should be refactored in order to
    // avoid code duplication
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

    public void setSurfaceArea(Long diameter) {
        this.surfaceArea = calculateSurfaceArea(diameter);
    }

    public Double calculateSurfaceArea(Long diameter) {
        if (diameter < 0) {
            throw new IllegalArgumentException("Diameter cannot be negative");
        }
        double surfaceArea = (4 * Math.PI * Math.pow(diameter / 2, 2));

        return Math.floor(surfaceArea);
    }
}
