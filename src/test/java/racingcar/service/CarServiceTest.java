package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

class CarServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void fail_car_forward(int input) {
        Car car = new Car("Test");
        CarService.forwardByRandomNumber(car, input);
        Assertions.assertEquals(car.getPosition(), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void success_car_forward(int input) {
        Car car = new Car("Test");
        CarService.forwardByRandomNumber(car, input);
        Assertions.assertEquals(car.getPosition(), 1);
    }

}