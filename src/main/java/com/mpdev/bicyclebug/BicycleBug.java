package com.mpdev.bicyclebug;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BicycleBug {
    private BicycleFrame frame;
    private int speed;
    private boolean breaksOn;

    public void setMaxSpeed(int maxSpeed) {
        frame.setMaxSpeed(maxSpeed);
    }

}
