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
        Accelerator accelerator = new RandomNumberAccelerator(MockNumberGenerator.createMockNumberGenerator(4));
        accelerator.move(car);
        assertEquals(car.getCarDistance(), 1);
    }

    @DisplayName("3 이하 자동차 이동 불가")
    @Test
    void NotMoveCar() {
        Car car = Car.createCarAtStartLine("fobi");
        Accelerator accelerator = new RandomNumberAccelerator(MockNumberGenerator.createMockNumberGenerator(3));
        accelerator.move(car);
        assertEquals(car.getCarDistance(), 0);
    }
}