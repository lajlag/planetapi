package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Planet;

import repository.PlanetRepository;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class PlanetController {

    @Autowired
    PlanetRepository planetRepository;

    @GetMapping("/planets")
    public ResponseEntity<List<Planet>> getAllPlanets(@RequestParam(required = false) String name) {
        try {
            List<Planet> planets = new ArrayList<Planet>();

            if (name == null)
                planetRepository.findAll().forEach(planets::add);
            else
                planetRepository.findByName(name).forEach(planets::add);

            if (planets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(planets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
