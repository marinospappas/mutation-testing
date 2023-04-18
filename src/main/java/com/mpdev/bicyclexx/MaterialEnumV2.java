package com.mpdev.bicyclexx;

public enum MaterialEnumV2 {
    Aluminium(20),
    Titanium(25),
    Carbon(29),
    Steel(10);

    private final int maxSpeed;

    MaterialEnumV2(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    int getMaxSpeed() {
        return maxSpeed;
    }
}
