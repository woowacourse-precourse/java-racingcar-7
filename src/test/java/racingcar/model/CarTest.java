package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @DisplayName("자동차 이동 테스트")
    @Test
    void move_success(){
        String carName = "test1";
        Car car = new Car(carName);

        car.move(4);
        car.move(3);
        car.move(2);
        car.move(9);
        car.move(7);

        assertEquals(3,car.getPosition());
    }

    @DisplayName("자동차 이름 테스트")
    @Test
    void carName_success(){
        String carName = "ori-2";
        Car car = new Car(carName);

        assertEquals("ori-2", car.getName());
    }

}