package com.mpdev.bikerace;

import com.mpdev.bicyclev1.Bicycle;
import com.mpdev.exception.HighSpeedException;

public class BikeRace {

    public static void main(String[] args) {
        (new BikeRace()).runThis();
    }

    private void runThis() {
        var bike1 = setBike("Titanium");
        var bike2 = setBike("Aluminium");
        accelerate(bike1);
        accelerate(bike2);
        var winner = getWinner(bike1, bike2);
        if (winner == null)
            System.out.println("it's a draw");
        else
            System.out.println("winner is "+winner);
    }

    public Bicycle setBike(String material) {
        var bike = Bicycle.builder().material(material).speed(0).breaksOn(true).build();
        bike.setMaxSpeedFromMaterial();
        return bike;
    }

    public void accelerate(Bicycle bike) {
        bike.releaseBreak();
        while (bike.getSpeed() < bike.getMaxSpeed())
            bike.accelerate();
        try {
            bike.isSpeedValid();
        }
        catch(HighSpeedException e) {
            System.err.println(bike + " has exceeded max speed");
            System.exit(1);
        }
    }

    public Bicycle getWinner(Bicycle bike1, Bicycle bike2) {
        return (bike1.getSpeed() > bike2.getSpeed()) ? bike1 :
                (bike2.getSpeed() > bike1.getSpeed()) ? bike2 : null;
    }
}
