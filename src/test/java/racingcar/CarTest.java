package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MOVING_FORWARD = 4;

    @Test
    void blankNameTest() {
        assertThatThrownBy(() -> new Car("  ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nameLengthTest() {
        assertThatThrownBy(() -> new Car("Looong")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveTest() {
        Car car = new Car("test");

        assertRandomNumberInRangeTest(() -> {
            car.move();
            assertThat(car.getPosition()).isEqualTo(1);
        }, MOVING_FORWARD);
    }

    @Test
    void equalsTest() {
        Car car1 = new Car("test");
        Car car2 = new Car("test");

        assertThat(car1).isEqualTo(car2);
    }
}