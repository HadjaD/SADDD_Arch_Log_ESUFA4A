package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoveForwardBackwardTest {

    PlanetMapInit map = new PlanetMapInit(50, 50, 0.15);
    int height;
    int weight;
    @Before
    public void beforeTestCreateGrid() {
        map = new PlanetMapInit(50, 50, 0.15);

    }

    @ParameterizedTest
    @CsvSource({
        "b, 0, -1, NORTH",
        "l, 0, 0, WEST",
        "r, 0, 0, EAST",
        "ff, 0, 2, NORTH",
        "lf, -1, 0, WEST",
        "rf, 1, 0, EAST",
        "llf, 0, -1, SOUTH",
        "bb, 0, -2, NORTH",
        "lb, 1, 0, WEST",
        "llb, 0, 1, SOUTH",
        "rb, -1, 0, EAST",
        "fflb, 1, 2, WEST"
    })
    void rover_moves_forward_backward(String command, int expectedX, int expectedY, Direction expectedDirection) {
        MarsRover marsRover = new MarsRoverImpl(0, 0, Direction.NORTH, map);

        Position newPosition = marsRover.move(command);
        //Assertions.assertThat(newPosition).isEqualTo(Position.of(expectedX, expectedY, expectedDirection));
        Assertions.assertThat(newPosition).isEqualToComparingFieldByField(Position.of(expectedX, expectedY, expectedDirection));
    }
}
