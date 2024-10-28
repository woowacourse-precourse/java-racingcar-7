package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    @DisplayName("자동차 이동 - 조건 충족")
    void carMovesWhenConditionMet() {
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이동 - 조건 미충족")
    void carDoesNotMoveWhenConditionNotMet() {
        car.move(3);
        assertEquals(0, car.getPosition());
    }
}
