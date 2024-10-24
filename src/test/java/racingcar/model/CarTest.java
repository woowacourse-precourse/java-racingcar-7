package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차이름_5자초과_예외발생() {

        String carName = "pobicarname";

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            new Car(carName);
        });

        assertEquals("자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    void 자동차이름_5자이하_정상작동() {

        String carName = "pobi";

        Car car = new Car(carName);

        assertEquals(carName, car.getName());
        assertEquals(0, car.getLocation());
    }
}