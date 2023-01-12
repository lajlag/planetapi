package com.planetapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.planetapi.model.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    // TODO: does not work with native query
    @Query(value = "SELECT * FROM planets p WHERE LOWER( p.name ) LIKE :name", nativeQuery = true)
    List<Planet> findByNameContaining(@Param("name") String name);
}
