package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다")
    @Test
    void createCarWithLongName() {
        assertThatThrownBy(() -> new Car("pobi123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 빈 문자열이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    void createCarWithEmptyName(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 null이면 예외가 발생한다")
    @Test
    void createCarWithNullName() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("4 이상의 숫자가 나오면 자동차가 전진한다")
    void moveForwardWhenNumberIsGreaterThanThree() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("3 이하의 숫자가 나오면 자동차가 멈춘다")
    void stopWhenNumberIsLessThanFour() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(0);
                },
                STOP
        );
    }
}
