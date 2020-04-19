package com.esiea.tp4A.jeu;

import com.esiea.tp4A.domain.Position;

public interface RoverApi {
    Position getPosition(String player);
    LocalMap getPlayerLocalMap(String player, int localMapSize);
    int getLaserRange();
    Rover playerMove(String player ,String command);
    void laserShoot(String player);
    boolean isPlayerAlive(String player);
}
