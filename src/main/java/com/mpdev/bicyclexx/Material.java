package com.mpdev.bicyclexx;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Material {

    private MaterialEnum material;
    private int maxSpeed;

}
