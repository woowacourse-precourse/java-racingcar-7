package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 객체가 정상적으로 생성된다.")
    void createCar() {
        String name = "pobi";

        Car car = new Car(name);

        assertEquals(car.getName(),name);
        assertEquals(car.getPosition(),0);
    }

    @Test
    @DisplayName("자동차가 정상적으로 움직인다.")
    void moveForwardCar() {
        Car car = new Car("pobi");

        car.moveForward();

        assertEquals(1, car.getPosition());
    }

}
