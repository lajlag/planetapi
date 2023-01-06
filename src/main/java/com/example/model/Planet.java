package com.example.model;

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
    private int population;

    // TODO: relations
    // residents
    // films

    // "name": "Yavin IV",
    // "rotation_period": "24",
    // "orbital_period": "4818",
    // "diameter": "10200",
    // "climate": "temperate, tropical",
    // "gravity": "1 standard",
    // "terrain": "jungle, rainforests",
    // "surface_water": "8",
    // "population": "1000",
    // "residents": [],
    // "films": [
    // "https://swapi.dev/api/films/1/"
    // ],
    // @Column(name = "planetData", )
    // private PlanetData planetData;

    public Planet() {
    }

    private class PlanetData {
    }

    // public Planet(Long id, String name, int population, PlanetData planetData) {
    public Planet(Long id, String name, int population) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.id = id;
        this.name = name;
        this.population = population;
        // this.planetData = planetData;
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

    // public PlanetData getPlanetData() {
    // return planetData;
    // }

    // public void setPlanetData(PlanetData planetData) {
    // if (planetData == null) {
    // throw new IllegalArgumentException("Input object cannot be null");
    // }
    // this.planetData = planetData;
    // }
}
