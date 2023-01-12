package com.planetapi.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.planetapi.model.Planet;
import com.planetapi.model.PlanetApiModel;
import com.planetapi.model.PlanetDto;
import com.planetapi.repository.PlanetRepository;

@Service
public class PlanetService {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public List<PlanetApiModel> findAllStarWarsPlanets() {
        String url = "https://swapi.dev/api/planets/";
        PlanetApiModel result = restTemplate.getForObject(url, PlanetApiModel.class);
        List<PlanetApiModel> results = Arrays.asList(result);

        return results;
    }

    private Planet convertToPlanetEntity(PlanetDto planetDto) {
        Planet planet = modelMapper.map(planetDto, Planet.class);

        return planet;
    }

    public void saveAllStarWarsPlanets() {
        List<PlanetApiModel> results = findAllStarWarsPlanets();
        results.forEach(result -> {
            result.getResults().forEach(planetDto -> {
                Planet planetToSave = convertToPlanetEntity(planetDto);
                planetRepository.save(planetToSave);
            });
        });
    }
}
