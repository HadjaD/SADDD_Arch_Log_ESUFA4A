package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LaserTest {

    public final PlanetMapInit planetMapInit = new PlanetMapInit(0,100, 5.8);
    public final Laser laser = new Laser(planetMapInit, 2);

    @ParameterizedTest
    @CsvSource({

    })

    void shootingNorth(int XpositionRover, int YpositionRover, int xObstacle, int yObstacle, Direction direction, Direction directionshoot, boolean expectedObstacle){
        //Position position = new Position()
    }



}
