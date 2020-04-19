package com.esiea.tp4A.jeu;

import com.esiea.tp4A.domain.Position;

import java.io.Serializable;
import java.util.Set;

public class Laser implements Serializable {
    private final int range;
    private final Jeu jeu;

    public Laser(int range, Jeu jeu) {
        this.range = range;
        this.jeu = jeu;
    }

    public Position shoot(Position playerPosition){
        Position laser_position = playerPosition;
        RoverPosition roverPosition = new RoverPosition(this.jeu.getPlanetMap());
        for (int i = 0; i < range; i++) {
            laser_position = roverPosition.forward(laser_position, true);
            if(jeu.dealShot(laser_position)) return laser_position;
        }
        return laser_position;
    }

    public int getRange() {
        return range;
    }
}
