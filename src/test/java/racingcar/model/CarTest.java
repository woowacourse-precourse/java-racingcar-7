package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarException;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 null일 경우 테스트")
    void carNameIsNullTest() {
        //given
        final String carName = null;

        //when & then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarException.CAR_NAME_IS_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 테스트")
    void carNameIsEmptyTest() {
        //given
        final String carName = "";

        //when & then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarException.CAR_NAME_IS_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 테스트")
    void carNameIsOverFiveTest() {
        //given
        final String carName = "abcdef";

        //when & then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarException.CAR_NAME_IS_OVER_FIVE.getMessage());
    }

    @Test
    @DisplayName("차량 정상 생성 테스트")
    void carCreateTest() {
        //given
        final String carName = "car";

        //when
        final Car car = new Car(carName);

        //then
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("차량 이동 테스트")
    void moveTest() {
        //given
        final String carName = "car";
        final Car car = new Car(carName);

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}