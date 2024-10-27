package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.Test;

class CarTest {

    private Car car = new Car("bill");
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("bill");
    }

    @Test
    void getPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void roleDice() {
        assertThat(car.getPosition()).isEqualTo(0);
        assertRandomNumberInRangeTest(
            () -> {
                car.roleDice(0,9);
                assertThat(car.getPosition()).isEqualTo(1);
            },
            MOVING_FORWARD
        );
    }
}