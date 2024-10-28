package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @DisplayName("자동차가 이동 조건을 만족할 때 이동하는지 테스트")
    void testMoveIfPossibleWhenCanMove() {
        Car car = new Car("testCar");

        car.moveIfPossible(4);
        assertEquals(1, car.getPosition());

        car.moveIfPossible(5);
        assertEquals(2, car.getPosition());
    }

    @Test
    @DisplayName("자동차가 이동 조건을 만족하지 않을 때 이동하지 않는지 테스트")
    void testMoveIfPossibleWhenCannotMove() {
        Car car = new Car("testCar");

        car.moveIfPossible(3);
        assertEquals(0, car.getPosition());

        car.moveIfPossible(2);
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차의 초기 위치와 이름이 올바르게 설정되는지 테스트")
    void testCarInitialization() {
        Car car = new Car("testCar");

        assertEquals("testCar", car.getName());
        assertEquals(0, car.getPosition());
    }
}
