package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.RacingConstants.INITIAL_MOVE_COUNT;
import static racingcar.RacingConstants.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.RacingConstants.MIN_LENGTH_OF_CAR_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @DisplayName("최소 길이보다 짧은 이름을 전달받으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"    "})
    @NullAndEmptySource
    void throwExceptionIfGetNameShorterThanMinLength(String name) {
        assertThatThrownBy(() -> new Car(name, INITIAL_MOVE_COUNT))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(MIN_LENGTH_OF_CAR_NAME));
    }

    @DisplayName("최대 길이보다 긴 이름을 전달받으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"sarang", "sarangkim", "jaesungpark"})
    void throwExceptionIfGetNameLongerThanMaxLength(String name) {
        assertThatThrownBy(() -> new Car(name, INITIAL_MOVE_COUNT))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(MAX_LENGTH_OF_CAR_NAME));
    }

    @DisplayName("전달받은 이름의 길이가 유효하면 Car 인스턴스 생성")
    @ParameterizedTest
    @ValueSource(strings = {"k", "go", "pobi", "saera", "won.i"})
    void createCar(String name) {
        assertThat(new Car(name, INITIAL_MOVE_COUNT)).isExactlyInstanceOf(Car.class);
    }

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