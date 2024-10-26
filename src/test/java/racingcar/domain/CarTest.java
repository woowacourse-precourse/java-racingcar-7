package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final String DEFAULT_NAME = "name";

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void validateTest_whenNameIsEmpty_throwsException(String emptyName) {
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1글자 이상 5글자 이하이어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef"})
    void validateTest_whenNameLengthIsOverBound_throwsException(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1글자 이상 5글자 이하이어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void moveTest_whenSuppliedNumberIsOverBound_moveForward(int overBoundNumber) {
        NumberSupplier overBoundSupplier = () -> overBoundNumber;
        Car car = new Car(DEFAULT_NAME, overBoundSupplier);
        int expectedPosition = car.getPosition() + 1;

        car.move();

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void moveTest_whenSuppliedNumberIsUnderBound_stop(int underBoundNumber) {
        NumberSupplier overBoundSupplier = () -> underBoundNumber;
        Car car = new Car(DEFAULT_NAME, overBoundSupplier);
        int expectedPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
