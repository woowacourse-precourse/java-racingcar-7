package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingConstants.INITIAL_MOVE_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("true를 전달받으면 위치값 반환")
    @Test
    void returnPositionIfGetTrue() {
        Car car = new Car("pobi", INITIAL_MOVE_COUNT);

        int actual = car.moveForwardIf(true);

        assertThat(actual).isEqualTo(INITIAL_MOVE_COUNT + 1);
    }

    @DisplayName("false를 전달받으면 -1 반환")
    @Test
    void returnMinusOneIfGetFalse() {
        Car car = new Car("pobi", INITIAL_MOVE_COUNT);

        int actual = car.moveForwardIf(false);

        assertThat(actual).isEqualTo(-1);
    }
}