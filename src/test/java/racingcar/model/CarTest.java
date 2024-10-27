package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void createCarTest() {
        // given
        String name = "pobi";

        // when
        Car car = Car.of(name);

        // then
        assertEquals(name, car.getName());
        assertEquals(0, car.getPosition());
    }

}
