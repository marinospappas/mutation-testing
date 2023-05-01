package com.mpdev.bicyclebug;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BicycleFrame {

    private MaterialEnum material;
    private int maxSpeed;

}
