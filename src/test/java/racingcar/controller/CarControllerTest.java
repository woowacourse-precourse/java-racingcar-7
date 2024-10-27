package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarControllerTest {

    @Test
    void getMostMovedCar() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        cars.get(0).move();
        cars.get(0).move();

        int expect = 2;
        CarController carController = new CarController();

        assertEquals(carController.getMostMovedCar(cars), expect);
    }
}