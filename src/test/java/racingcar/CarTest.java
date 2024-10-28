package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Car.MAX_CAR_NAME_LENGTH;
import static racingcar.Car.MIN_CAR_NAME_LENGTH;
import static racingcar.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.ExceptionMessage.INVALID_LENGTH_RANGE_CAR_NAME;
import static racingcar.ExceptionMessage.NULL_CAR_NAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");

        car.move(5);
        car.move(5);
        car.move(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    void 무작위로_뽑은_값이_4_이상이면_전진한다(int value) {
        car.move(value);
        assertThat(car.getDistance()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void 무작위로_뽑은_값이_4_미만이면_전진하지않는다(int value) {
        car.move(value);
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    void 자동차의_이름과_현재_위치를_반환한다() {
        assertThat(car.getInfo()).isEqualTo("pobi : --");
    }

    @ParameterizedTest
    @ValueSource(strings = {" crong", "loopy "})
    void 자동차명_맨앞이나_맨뒤의_공백은_글자수에서_제외한다(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차명이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_CAR_NAME.getMessage());
    }

    @Test
    void 자동차명이_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pororo", "javajigi", "abc de"})
    void 자동차명이_5자_초과이면_예외가_발생한다(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_LENGTH_RANGE_CAR_NAME.getMessage(),
                        MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH, carName));
    }
}