package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.util.MockNumberGenerator;

class RandomNumberAcceleratorTest {

    @DisplayName("4 이상 자동차 이동")
    @Test
    void moveCar() {
        Car car = Car.createCarAtStartLine("fobi");
        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator(4);
        Accelerator accelerator = new RandomNumberAccelerator(mockNumberGenerator);
        accelerator.move(car);
        assertEquals(car.getCarDistance(), 1);
    }

    @DisplayName("3 이하 자동차 이동 불가")
    @Test
    void NotMoveCar() {
        Car car = Car.createCarAtStartLine("fobi");
        MockNumberGenerator mockNumberGenerator = new MockNumberGenerator(3);
        Accelerator accelerator = new RandomNumberAccelerator(mockNumberGenerator);
        accelerator.move(car);
        assertEquals(car.getCarDistance(), 0);
    }
}