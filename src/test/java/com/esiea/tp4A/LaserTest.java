package com.esiea.tp4A;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LaserTest {

    public final PlanetMapInit planetMapInit = new PlanetMapInit(0,100, 5.8);
    public final Laser laser = new Laser(planetMapInit, 2);

    @ParameterizedTest
    @CsvSource({
        "0, 0, 4, 7, 4, NORTH, true",
        "0, 0, 5, 7, 4, NORTH, false"

    })

    void shootingNorth(int XpositionRover, int YpositionRover, int xObstacle, int yObstacle, int range, Direction directionshoot, boolean expectedObstacle){
        //laser.Range(range);
        planetMapInit.obstaclePositions();
        laser.shootNorth();

    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 4, 7, 4, SOUTH, true",
        "0, 0, 5, 7, 4, SOUTH, false"

    })

    void shootingSouth(int XpositionRover, int YpositionRover, int xObstacle, int yObstacle, int range, Direction directionshoot, boolean expectedObstacle){

        laser.shootSouth();

    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 4, 7, 4, EAST, true",
        "0, 0, 5, 7, 4, EAST, false"

    })

    void shootingEast(int XpositionRover, int YpositionRover, int xObstacle, int yObstacle, int range, Direction directionshoot, boolean expectedObstacle){
        laser.shootEast();

    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 4, 7, 4, WEST, true",
        "0, 0, 5, 7, 4, WEST, false"

    })

    void shootingWest(int XpositionRover, int YpositionRover, int xObstacle, int yObstacle, int range, Direction directionshoot, boolean expectedObstacle){
        laser.shootWest();

    }


   /* void rover_should_not_move_when_obstacle_found(String command, int expectedX, int expectedY, Direction expectedDirection){
        map.addObstacle(Position.of(2, 2, Direction.NORTH));
        map.addObstacle(Position.of(-24, 0, Direction.NORTH));
        MarsRover marsRover = new MarsRoverImpl(25, 0, Direction.NORTH, map);

        Position newPosition = marsRover.move(command);
        Assertions.assertThat(newPosition).isEqualToComparingFieldByField(Position.of(expectedX, expectedY, expectedDirection));
    }*/


}
