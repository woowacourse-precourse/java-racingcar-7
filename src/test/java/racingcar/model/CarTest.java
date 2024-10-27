package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void create_car() {
        String name = "pobi";

        Car car = new Car(name);

        assertEquals(name, car.getName());
    }


    @Test
    void move_once() {
        Car car = new Car("pobi");

        car.move();

        assertEquals(1, car.getDistance());
    }
}