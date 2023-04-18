package com.mpdev.bicyclev1;

import com.mpdev.exception.HighSpeedException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Bicycle {
    private String material;
    private int speed;
    private int maxSpeed;
    private boolean breaksOn;

    public void accelerate() {
        if (!breaksOn) {
            if (speed < getMaxSpeed()/2)
                speed += 3;
            else if (speed < getMaxSpeed())
                speed += 2;
        }
    }

    public void isSpeedValid() throws HighSpeedException {
        if (speed > maxSpeed)
            throw new HighSpeedException("Biciyle has exceeded max speed of" + maxSpeed);
    }

    public void setMaxSpeedFromMaterial() {
        if ("Titanium".equals(material))
            maxSpeed = 37;
        else
        if ("Aluminium".equals(material))
            maxSpeed = 25;
    }

    public void setBreak() {
        breaksOn = true;
    }

    public void releaseBreak() {
        breaksOn = false;
    }

}
