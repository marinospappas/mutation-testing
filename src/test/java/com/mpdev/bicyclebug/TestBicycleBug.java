package com.mpdev.bicyclebug;

import org.junit.jupiter.api.*;

import static com.mpdev.bicyclebug.MaterialEnum.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBicycleBug {

    @BeforeAll
    static void setup() {
        FramesMap.initFramesMap();
    }

    @Test
    @Order(1)
    @DisplayName("Bicycle properties are correctly set")
    void testBicycleProperties() {
        BicycleBug bicycle = BicycleBug.builder().frame(FramesMap.getMaterial("TI")).speed(0).breaksOn(true).build();
        assertEquals(Titanium, bicycle.getFrame().getMaterial());
        assertEquals(Titanium.getMaxSpeed(), bicycle.getFrame().getMaxSpeed());
        assertTrue(bicycle.isBreaksOn());
        assertEquals(0, bicycle.getSpeed());
    }

    @Test
    @Order(2)
    @DisplayName("Maximum speed override sets correct max speed")
    void testMaxSpeedOverride() {
        BicycleBug bicycle = BicycleBug.builder().frame(FramesMap.getMaterial("TI")).speed(0).breaksOn(true).build();
        assertEquals(Titanium.getMaxSpeed(), bicycle.getFrame().getMaxSpeed());
        int newMaxSpeed = 39;
        bicycle.setMaxSpeed(newMaxSpeed);
        assertEquals(newMaxSpeed, bicycle.getFrame().getMaxSpeed());

    }

}
