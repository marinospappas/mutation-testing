package com.mpdev.bicyclexx;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BicycleX {
    private String material;
    private int speed;
    private int maxSpeed;
    private boolean breaksOn;

    void accelerate() throws HighSpeedException {
        if (!breaksOn) {
            if (speed < getMaxSpeed()/2)
                speed += 3;
            else if (speed < getMaxSpeed())
                speed += 2;
        }
        if (speed > getMaxSpeed())
            throw new HighSpeedException("bicycle exceeded max speed of "+getMaxSpeed());
    }

    void setBreak() {
        breaksOn = true;
    }

    void releaseBreak() {
        breaksOn = false;
    }

}
