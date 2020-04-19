package com.esiea.tp4A.jeu;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerOutput {
    private final Rover player;
    private final LocalMap localMap;

    public PlayerOutput(Rover player, LocalMap localMap) {
        this.player = player;
        this.localMap = localMap;
    }

    @JsonProperty("player")
    public Rover getPlayer() {
        return player;
    }

    @JsonProperty("local-map")
    public LocalMap getLocalMap() {
        return localMap;
    }
}
