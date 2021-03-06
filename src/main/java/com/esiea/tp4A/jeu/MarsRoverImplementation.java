package com.esiea.tp4A.jeu;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.PlanetMap;
import com.esiea.tp4A.domain.Position;

public class MarsRoverImplementation implements MarsRover {
    private Position position;
    private final PlanetMap map;

    public MarsRoverImplementation(int x, int y, Direction direction, PlanetMap map) {
        position = Position.of(x, y, direction);
        this.map = map;
    }
    @Override
    public Position move(String command) {
        if (command.isEmpty()) {
            return position;
        }
        for(char singleCommand: command.toCharArray()) {
            if ('f' == singleCommand) {
                position = position.forward(this.map);
            } else if ('b' == singleCommand) {
                position = position.backward(this.map);
            } else if ('l' == singleCommand) {
                position = position.left();
            } else {
                position = position.right();
            }
        }
        return position;
    }
}
