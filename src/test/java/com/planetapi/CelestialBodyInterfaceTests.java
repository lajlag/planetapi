package com.planetapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.planetapi.model.CelestialBodyInterface;
import com.planetapi.model.Planet;

public class CelestialBodyInterfaceTests {
    @Test
    public void surfaceAreaCalculationShouldReturnTrue() {
        // Arrange
        long diameter = 20;
        CelestialBodyInterface celestialBody = new Planet(20);
        Double expectedSurfaceArea = 1256.00;

        // Act
        Double actualSurfaceArea = celestialBody.calculateSurfaceArea(diameter);

        // Assert
        assertEquals(expectedSurfaceArea, actualSurfaceArea);
    }

    @Test
    public void negativeDiameterShouldThrowException() {
        // Arrange
        long diameter = -20;
        CelestialBodyInterface celestialBody = new Planet(20);

        // Act
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> celestialBody.calculateSurfaceArea(diameter));

        // Assert
        assertTrue(thrown.getMessage().contains("Diameter cannot be negative"));
    }
}
