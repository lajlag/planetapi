package com.planetapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planetapi.model.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    // TODO: Implement
    Optional<Planet> findByName(String name);
}
