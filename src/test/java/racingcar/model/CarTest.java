package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;
    private final String TEST_CAR = "pobi";

    @BeforeEach
    void setUp() {
        car = new Car(TEST_CAR);
    }

    @Test
    @DisplayName("차량 이동 테스트")
    void move() {
        car.move();
        assertEquals(1, car.getDistance());
    }

    @Test
    @DisplayName("차량 이름 호출 테스트")
    void getName() {
        assertEquals(TEST_CAR, car.getName());
    }

    @Test
    @DisplayName("차량 이동 거리 호출 테스트")
    void getDistance() {
        car.move();
        car.move();
        assertEquals(2, car.getDistance());
    }
}