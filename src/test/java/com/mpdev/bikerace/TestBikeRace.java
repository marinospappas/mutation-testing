package com.mpdev.bikerace;

import com.mpdev.bicyclev1.Bicycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TestBikeRace {

    private final BikeRace bikeRace = new BikeRace();

    private final Bicycle bike1 = Mockito.mock(Bicycle.class);
    private final Bicycle bike2 = Mockito.mock(Bicycle.class);

    @BeforeEach
    void setup() {
        when(bike1.getMaxSpeed()).thenReturn(25);
        when(bike1.getSpeed())
                .thenReturn(0)
                .thenReturn(3)
                .thenReturn(25);
        when(bike1.isBreaksOn())
                .thenReturn(true)
                .thenReturn(false);

        when(bike2.getMaxSpeed()).thenReturn(37);
        when(bike2.getSpeed())
                .thenReturn(0)
                .thenReturn(3)
                .thenReturn(37);
        when(bike2.isBreaksOn())
                .thenReturn(true)
                .thenReturn(false);
    }

    @Test
    void bikeInstanceIsCreatedCorrectly() {
        assertEquals(0, bike1.getSpeed());
        assertEquals(25, bike1.getMaxSpeed());
        assertTrue(bike1.isBreaksOn());
    }

    @Test
    void bike1SpeedReachesMaxSpeed() {
        assertTrue(bike1.isBreaksOn());
        bikeRace.accelerate(bike1);
        assertFalse(bike1.isBreaksOn());
        assertEquals(25, bike1.getSpeed());
    }

    @Test
    void bike2SpeedReachesMaxSpeed() {
        assertTrue(bike2.isBreaksOn());
        bikeRace.accelerate(bike2);
        assertFalse(bike2.isBreaksOn());
        assertEquals(37, bike2.getSpeed());
    }

    @Test
    void fastestBikeIsWinner() {
        bikeRace.accelerate(bike1);
        bikeRace.accelerate(bike2);
        assertEquals(bike2, bikeRace.getWinner(bike1, bike2));
    }
}
