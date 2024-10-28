package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_생성() {
        String testName = "test";

        Car car = new Car(testName);

        Assertions.assertEquals(car.getCarName(), testName);
    }
}