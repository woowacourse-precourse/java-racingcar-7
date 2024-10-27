package racingcar.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTests {
    private static final String EMPTY_NAME = "";
    private static final String LONG_NAME = "우아한테크코스라는매우긴이름";

    @Test
    void carInitialMoveCountIsZero() {
        Car car = Car.of("car");
        assertThat(car.getMoveCount()).isZero();
    }

    @Test
    void carThrowsExceptionWhenNameIsEmpty() {
        assertThatThrownBy(() -> Car.of(EMPTY_NAME))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carThrowsExceptionWhenNameIsTooLong() {
        assertThatThrownBy(() -> Car.of(LONG_NAME))
                .isInstanceOf(IllegalArgumentException.class);
    }
}