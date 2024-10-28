package racingcar.strategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class MoveRandomlyStrategyTest {
    private static final int MOVING_FORWARD = 4;

    @Test
    void move() {
        Car car = new Car("Test");
        MoveStrategy moveStrategy = new MoveRandomlyStrategy();

        assertRandomNumberInRangeTest(() -> {
            moveStrategy.move(car);
            assertThat(car.getPosition()).isEqualTo(1);
        }, MOVING_FORWARD);
    }
}