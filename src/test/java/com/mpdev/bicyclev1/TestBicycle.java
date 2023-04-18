package com.mpdev.bicyclev1;

import com.mpdev.exception.HighSpeedException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBicycle {

    @Test
    @Order(1)
    @DisplayName("Bicycle properties are correctly set")
    void testBicycleProperties() {
        Bicycle bicycle = Bicycle.builder().material("Titanium").speed(0).breaksOn(true).build();
        bicycle.setMaxSpeedFromMaterial();
        assertEquals("Titanium", bicycle.getMaterial());
        assertEquals(0, bicycle.getSpeed());
        assertEquals(37, bicycle.getMaxSpeed());
        assertTrue(bicycle.isBreaksOn());
    }

    @ParameterizedTest
    @Order(3)
    @DisplayName("Accelerate sets the speed correctly")
    @CsvSource({
            "Aluminium, 0, 3",
            "Aluminium, 16, 18",
            "Titanium, 0, 3",
            "Titanium, 20, 22",
    })
    void testAccelerate(String material, String speedStr, String expSpeed) {
        Bicycle bicycle = Bicycle.builder().material(material).speed(0).breaksOn(true).build();
        bicycle.setMaxSpeedFromMaterial();
        bicycle.releaseBreak();
        bicycle.setSpeed(Integer.parseInt(speedStr));
        bicycle.accelerate();
        assertEquals(Integer.parseInt(expSpeed), bicycle.getSpeed());
    }

    @Test
    @Order(4)
    @DisplayName("Brakes are set and released")
    void testBreak() {
        Bicycle bicycle = Bicycle.builder().material("Aluminium").speed(0).breaksOn(true).build();
        assertTrue(bicycle.isBreaksOn());
        bicycle.releaseBreak();
        assertFalse(bicycle.isBreaksOn());
        bicycle.setBreak();
        assertTrue(bicycle.isBreaksOn());
    }

    /*
    @Test
    @Order(5)
    @DisplayName("When maxSpeed exceeded Exception is raised")
    void testVerifySpeed() {
        Bicycle bicycle = Bicycle.builder().material("Aluminium").speed(0).breaksOn(true).build();
        bicycle.setMaxSpeedFromMaterial();
        bicycle.setSpeed(20);
        assertDoesNotThrow(bicycle::isSpeedValid);
        bicycle.setSpeed(26);
        assertThrows(HighSpeedException.class, bicycle::isSpeedValid);
    }
    */

}
