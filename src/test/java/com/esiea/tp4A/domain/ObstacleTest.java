package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ObstacleTest {
    PlanetMapInit map = new PlanetMapInit(50, 50, 0.15);
    int height;
    int weight;

    @ParameterizedTest
    @CsvSource({
        "rf, 25, 0, EAST",
    })
    void rover_should_not_move_when_obstacle_found(String command, int expectedX, int expectedY, Direction expectedDirection){
        map.addObstacle(Position.of(2, 2, Direction.NORTH));
        map.addObstacle(Position.of(-24, 0, Direction.NORTH));
        MarsRover marsRover = new MarsRoverImpl(25, 0, Direction.NORTH, map);

        Position newPosition = marsRover.move(command);
        Assertions.assertThat(newPosition).isEqualToComparingFieldByField(Position.of(expectedX, expectedY, expectedDirection));
    }
}
