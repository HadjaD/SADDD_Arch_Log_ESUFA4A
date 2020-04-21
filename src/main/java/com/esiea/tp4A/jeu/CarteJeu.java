package com.esiea.tp4A.jeu;

import com.esiea.tp4A.domain.Position;

import java.util.Set;

public class CarteJeu {
    private final Set<MarsRoverImplementation> marsRoverImplementation;
    private final Set<Position.FixedPosition> obstacles;

    public CarteJeu(Set<MarsRoverImplementation> marsRoverImplementation, Set<Position.FixedPosition> obstacles) {
        this.marsRoverImplementation = marsRoverImplementation;
        this.obstacles = obstacles;
    }

}
