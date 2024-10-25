package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("차량 이동 테스트- seed가 4 이상일 경우")
    void moveTestWhenSeedIsMoreThanFour() {
        //given
        final String carName = "car";
        final int seed = 4;
        final Car car = new Car(carName);

        //when
        car.move(seed);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차량 이동 테스트 - seed가 4 미만일 경우")
    void moveTestWhenSeedIsLessThanFour() {
        //given
        final String carName = "car";
        final int seed = 3;
        final Car car = new Car(carName);

        //when
        car.move(seed);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}