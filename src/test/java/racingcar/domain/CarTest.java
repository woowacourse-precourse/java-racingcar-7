package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 생성 시 이름은 입력값으로, 포지션은 0으로 초기화된다.")
    void 자동차_초기화() {
        // given
        String carName = "kim";

        // when
        Car car = new Car(carName);

        // then
        assertEquals(carName, car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 전진 시 포지션이 하나씩 증가한다.")
    void 자동차_전진() {
        // given
        Car car = new Car("kim");

        // when
        car.forward();

        // then
        assertEquals(1, car.getPosition());
    }
}