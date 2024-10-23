package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("name으로 Car를 생성할 수 있다.")
    @Test
    void createCarByName() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.from(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("Car의 초기 position은 0 이다.")
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