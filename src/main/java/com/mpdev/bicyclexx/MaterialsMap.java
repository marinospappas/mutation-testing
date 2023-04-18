package com.mpdev.bicyclexx;

import java.util.HashMap;
import java.util.Map;

public class MaterialsMap {

    private static final Map<String,Material> materialMap = new HashMap<>();

    public static void initMaterialsMap() {
        materialMap.put("AL", new Material(MaterialEnum.Aluminium, 20));
        materialMap.put("TI", new Material(MaterialEnum.Titanium, 25));
        materialMap.put("CA", new Material(MaterialEnum.Carbon, 29));
    }

    static Material getMaterial(String materialCode) {
        return materialMap.getOrDefault(materialCode, new Material(MaterialEnum.Unknown, 15));
    }
}
