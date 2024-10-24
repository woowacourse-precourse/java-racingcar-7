package racingcar.model;

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
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarException.CAR_NAME_IS_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 테스트")
    void carNameIsEmptyTest() {
        //given
        final String carName = "";

        //when & then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarException.CAR_NAME_IS_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 테스트")
    void carNameIsOverFiveTest() {
        //given
        final String carName = "abcdef";

        //when & then
        Assertions.assertThatThrownBy(() -> new Car(carName))
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
        Assertions.assertThat(car).isNotNull();
    }
}