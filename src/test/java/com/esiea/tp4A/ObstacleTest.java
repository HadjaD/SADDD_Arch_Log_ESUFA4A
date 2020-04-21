package com.esiea.tp4A;
import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObstacleTest {

    Position.FixedPosition fixedPosition = new Position.FixedPosition(50, 50, Direction.NORTH);

    @Test
    public void obstacle_test() {
        assertThat(fixedPosition.isObstacle).isEqualTo(false);
    }

}
