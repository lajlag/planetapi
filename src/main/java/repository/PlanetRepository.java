package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    List<Planet> findByName(String name);

}
