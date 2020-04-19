package com.esiea.tp4A.jeu;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Set;

public class LocalMap implements Serializable {
    private final Set<Rover> rovers;
    private final Set<Obstacle> obstacles;

    public LocalMap(Set<Rover> rovers, Set<Obstacle> obstacles) {
        this.rovers = rovers;
        this.obstacles = obstacles;
    }

    @JsonProperty("players")
    public Set<Rover> getPlayers() { return rovers; }

    @JsonProperty("obstacles")
    public Set<Obstacle> getObstacles() {
        return obstacles;
    }
}
