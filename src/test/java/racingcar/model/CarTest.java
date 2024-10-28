package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 거리를 증가시킬 수 있다")
    void 자동차_이동_테스트() {
        // given
        Car car = new Car("TestCar", 0);

        // when
        car.increaseDistance();

        // then
        assertEquals(1, car.getDistance());
    }


}
