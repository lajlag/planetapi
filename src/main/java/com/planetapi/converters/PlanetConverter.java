// package com.planetapi.converters;

// import java.util.Map;

// import javax.persistence.AttributeConverter;
// import javax.persistence.Converter;

// import com.planetapi.model.types.PlanetData;

// @Converter
// public class PlanetConverter implements AttributeConverter<Map<String,
// Object>, String> {

// @Override
// public String convertToPlanetDataDatabaseColumn(PlanetData planetData) {
// if (planetData == null) {
// return null;
// }

// StringBuilder sb = new StringBuilder();
// sb.append(planetData.getRotationPeriod());
// sb.append(planetData.getOrbitalPeriod());
// sb.append(planetData.getDiameter());
// sb.append(planetData.getSurfaceWater());
// sb.append(planetData.getClimate());
// sb.append(planetData.getTerrain());
// sb.append(planetData.getSurfaceWater());

// return sb.toString();
// }

// @Override
// public PlanetData convertToPlanetDataEntityAttribute(String planetDataDb) {
// if (planetDataDb == null || planetDataDb.isEmpty()) {
// return null;
// }

// PlanetData planetData = new PlanetData();

// return planetData;

// }
