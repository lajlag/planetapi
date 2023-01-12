package com.planetapi.model;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class PlanetListener {
    @PreUpdate
    @PrePersist
    public void checkPlanetProperties(Planet planet) {
        planet.setTerrain(planet.getTerrain().toLowerCase());
        planet.setClimate(planet.getClimate().toLowerCase());
        planet.setSurfaceArea(planet.getDiameter());
    }
}
