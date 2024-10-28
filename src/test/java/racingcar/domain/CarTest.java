package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 생성 시 초기 위치는 0이어야 한다.")
    void car_initialPosition_shouldBeZero() {
        //given
        Car car = new Car("car1");

        //when & then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 때만 자동차가 이동해야 한다.")
    void car_shouldMove_whenRandomValueIsFourOrGreater() {
        //given
        Car car = new Car("car1");
        int initialPosition = car.getPosition();

        //when
        car.move(4);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("랜덤 값이 3 이하일 때 자동차가 이동하지 않아야 한다.")
    void car_shouldNotMove_whenRandomValueIsThreeOrLess() {
        //given
        Car car = new Car("car1");
        int initialPosition = car.getPosition();

        //when
        car.move(3);

        //then
        Assertions.assertThat(car.getPosition()).isEqualTo(initialPosition);
    }
}
