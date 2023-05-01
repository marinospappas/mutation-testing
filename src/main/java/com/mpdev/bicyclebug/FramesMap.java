package com.mpdev.bicyclebug;

import static com.mpdev.bicyclebug.MaterialEnum.*;

import java.util.HashMap;
import java.util.Map;

public class FramesMap {

    private static final Map<String, BicycleFrame> frameMap = new HashMap<>();

    public static void initFramesMap() {
        Map<String, BicycleFrame> frames = new HashMap<>();
        frames.put("AL", new BicycleFrame(Aluminium, Aluminium.getMaxSpeed()));
        frames.put("TI", new BicycleFrame(Titanium, Titanium.getMaxSpeed()));
        frames.put("CA", new BicycleFrame(Carbon, Carbon.getMaxSpeed()));
        frameMap.putAll(frames);
    }

    static BicycleFrame getMaterial(String materialCode) {
        return frameMap.getOrDefault(materialCode, new BicycleFrame(MaterialEnum.Unknown, 15));
    }
}
