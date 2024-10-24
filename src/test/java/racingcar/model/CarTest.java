package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_전진_시도_성공() {
        Car car = new Car("진용") {
            @Override
            public Boolean isMoved() {
                return true;
            }
        };
        car.move();
        assertEquals(1, car.distance);
    }

    @Test
    void 자동차_전진_시도_실패() {
        Car car = new Car("진용") {
            @Override
            public Boolean isMoved() {
                return false;
            }
        };

        car.move();
        assertEquals(0, car.distance);
    }
}