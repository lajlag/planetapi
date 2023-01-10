package com.planetapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planetapi.model.Planet;
import com.planetapi.repository.PlanetRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class PlanetController {

    Logger logger = LoggerFactory.getLogger(PlanetController.class);

    @Autowired
    PlanetRepository planetRepository;

    @GetMapping("/planets")
    public ResponseEntity<List<Planet>> getAllPlanets() {
        try {
            List<Planet> planets = new ArrayList<Planet>();
            planetRepository.findAll().forEach(planets::add);

            if (planets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(planets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/planets/{id}")
    public ResponseEntity<Planet> getPlanetById(@PathVariable("id") Long id) {
        Optional<Planet> planet = planetRepository.findById(id);

        if (planet.isPresent()) {
            return new ResponseEntity<Planet>(planet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/planets")
    public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) {
        try {
            Planet _planet = planetRepository
                    .save(new Planet(planet.getId(), planet.getName(), planet.getPopulation(),
                            planet.getRotationPeriod(), planet.getOrbitalPeriod(), planet.getDiameter(),
                            planet.getGravity(), planet.getClimate(), planet.getTerrain(), planet.getSurfaceWater()));
            return new ResponseEntity<>(_planet, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "planets/{id}")
    public ResponseEntity<Planet> updatePlanet(@PathVariable("id") Long id, @RequestBody Planet planet) {
        Optional<Planet> planetData = planetRepository.findById(id);

        if (planetData.isPresent()) {
            Planet _planet = planetData.get();
            if (planet.getName() != null) {
                _planet.setName(planet.getName());
            }
            if (planet.getPopulation() != null) {
                _planet.setPopulation(planet.getPopulation());
            }
            if (planet.getRotationPeriod() != null) {
                _planet.setRotationPeriod(planet.getRotationPeriod());
            }
            if (planet.getOrbitalPeriod() != null) {
                _planet.setOrbitalPeriod(planet.getOrbitalPeriod());
            }
            if (planet.getDiameter() != null) {
                _planet.setDiameter(planet.getDiameter());
            }
            if (planet.getClimate() != null) {
                _planet.setClimate(planet.getClimate());
            }
            if (planet.getTerrain() != null) {
                _planet.setTerrain(planet.getTerrain());
            }
            if (planet.getGravity() != null) {
                _planet.setGravity(planet.getGravity());
            }
            if (planet.getSurfaceWater() != null) {
                _planet.setSurfaceWater(planet.getSurfaceWater());
            }

            return new ResponseEntity<Planet>(planetRepository.save(_planet), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/planets/{id}")
    public ResponseEntity<HttpStatus> deletePlanetById(@PathVariable("id") long id) {
        try {
            planetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error occurred", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
