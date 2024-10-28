package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    void addMove_test() {
        Car car = new Car("TestCar");

        car.addMove();
        car.addMove();
        car.addMove();

        assertEquals(3, car.getMove());
    }
}