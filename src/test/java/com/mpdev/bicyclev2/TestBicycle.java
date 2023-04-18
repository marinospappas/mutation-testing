package com.mpdev.bicyclev2;

import com.mpdev.bicyclev1.Bicycle;
import com.mpdev.bicyclexx.HighSpeedException;
import com.mpdev.bicyclexx.MaterialsMap;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBicycle {

    @BeforeAll
    static void setup() {
        MaterialsMap.initMaterialsMap();
    }

    @Test
    @Order(1)
    @DisplayName("Bicycle properties are correctly set")
    void testBicycleProperties() {
        Bicycle bicycle = Bicycle.builder().material("Titanium").speed(0).maxSpeed(30).breaksOn(true).build();
        assertEquals("Titanium", bicycle.getMaterial());
        assertEquals(0, bicycle.getSpeed());
        assertEquals(30, bicycle.getMaxSpeed());
        assertTrue(bicycle.isBreaksOn());
    }

    @ParameterizedTest
    @Order(2)
    @DisplayName("Accelerate sets the speed correctly")
    @CsvSource({
            "Aluminium, 0, 3",
            "Aluminium, 15, 17",
            "Titanium, 0, 3",
            "Titanium, 20, 22",
    })
    void testAccelerate(String material, String speedStr, String expSpeed) throws HighSpeedException {
        Bicycle bicycle = Bicycle.builder().material(material).speed(0).breaksOn(true).build();
        bicycle.setMaxSpeedFromMaterial();
        bicycle.releaseBreak();
        bicycle.setSpeed(Integer.parseInt(speedStr));
        bicycle.accelerate();
        assertEquals(Integer.parseInt(expSpeed), bicycle.getSpeed());
    }

    @Disabled
    @ParameterizedTest
    @Order(3)
    @DisplayName("Exeeding maximum speed throws exception")
    @CsvSource({
            "Titanium, 0, ''",
            "Titanium, 30, Exception",
    })
    void testMaxSpeedException(String material, String speed, String exception) {
        Bicycle bicycle = Bicycle.builder().material(material).speed(0).breaksOn(true).build();
        bicycle.setMaxSpeedFromMaterial();
        bicycle.releaseBreak();
        bicycle.setSpeed(Integer.parseInt(speed));
        if (exception.equals("Exception"))
            assertThrows(HighSpeedException.class, bicycle::accelerate);
        else
            assertDoesNotThrow(bicycle::accelerate);
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

}
