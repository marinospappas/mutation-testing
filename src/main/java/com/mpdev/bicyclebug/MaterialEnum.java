package com.mpdev.bicyclebug;

public enum MaterialEnum {
    Aluminium(20),
    Titanium(25),
    Carbon(29),
    Unknown(15);

    private final int maxSpeed;

    MaterialEnum(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    int getMaxSpeed() {
        return maxSpeed;
    }
}
