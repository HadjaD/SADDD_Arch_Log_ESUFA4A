package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.Position;
import com.esiea.tp4A.jeu.MarsRoverImplementation;
import com.esiea.tp4A.jeu.PlanetMapInit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarteSpherique50Test {

    PlanetMapInit map = new PlanetMapInit(50, 50, 0.15);
    @Test
    void gridShouldNotBeNull(){
        Assertions.assertThat(map).hasNoNullFieldsOrProperties();
    }
    @ParameterizedTest
    @CsvSource({
        "f, 0, -24, NORTH",
        "rf, 1, 25, EAST",
        "ff, 0, -23, NORTH",
        "lf, -1, 25, WEST",
        "b, 0, 24, NORTH",
        "rb, -1, 25, EAST",
        "ff, 0, -23, NORTH",
        "fllf, 0, 25, SOUTH"
    })
    void rover_stays_on_edges_North_South(String command, int expectedX, int expectedY, Direction expectedDirection) {
        MarsRover marsRover = new MarsRoverImplementation(0, 25, Direction.NORTH, map);


        Position newPosition = marsRover.move(command);
        //Assertions.assertThat(newPosition).isEqualTo(Position.of(expectedX, expectedY, expectedDirection));
        Assertions.assertThat(newPosition).isEqualToComparingFieldByField(Position.of(expectedX, expectedY, expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({
        "lf, 25, 0, WEST",
        "lfrf, 25, 1, NORTH",
        "bllf, -24, -2, SOUTH",
        "lf, 25, 0, WEST",
        "lfb, -24, 0, WEST",
        "lfbllf, -23, 0, EAST",
        "lfllf, -24, 0, EAST",
        "lfllfb, 25, 0, EAST"
    })
    void rover_test_on_edges_of_X(String command, int expectedX, int expectedY, Direction expectedDirection) {
        MarsRover marsRover = new MarsRoverImplementation(-24, 0, Direction.NORTH, map);

        Position newPosition = marsRover.move(command);
        //Assertions.assertThat(newPosition).isEqualTo(Position.of(expectedX, expectedY, expectedDirection));
        Assertions.assertThat(newPosition).isEqualToComparingFieldByField(Position.of(expectedX, expectedY, expectedDirection));
    }
    @ParameterizedTest
    @CsvSource({
        "b, 0, -24, SOUTH",
        "rr, 0, 25, NORTH",
        "brr, 0, -24, NORTH",
        "brrb, 0, 25, NORTH",
    })
    void rover_backward_test_on_edges_of_Y(String command, int expectedX, int expectedY, Direction expectedDirection) {
        MarsRover marsRover = new MarsRoverImplementation(0, 25, Direction.SOUTH, map);

        Position newPosition = marsRover.move(command);
        //Assertions.assertThat(newPosition).isEqualTo(Position.of(expectedX, expectedY, expectedDirection));
        Assertions.assertThat(newPosition).isEqualToComparingFieldByField(Position.of(expectedX, expectedY, expectedDirection));
    }

}

