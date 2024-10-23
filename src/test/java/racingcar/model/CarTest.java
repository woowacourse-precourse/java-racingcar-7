package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차의 이름으로 자동차를 생성할 수 있다.")
    @Test
    void creatCar() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.from(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차의 초기 위치 값은 0 이다.")
    @Test
    void createCarSetPositionIsZero() {
        //given
        String carName = "woni";

        //when
        Car car = Car.from(carName);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}