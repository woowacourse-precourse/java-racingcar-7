package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.strategy.AlwaysMoveStrategy;

public class CarTest {

    @Test
    @DisplayName("자동차가 이동할 수 있는 경우 전진한다")
    void shouldMoveWhenCanMoveReturnsTrue() {
        Car car = new Car("Car1", new AlwaysMoveStrategy());
        int initialPosition = car.getPosition();
        car.move();
        assertEquals(initialPosition + 1, car.getPosition());
    }

    @Test
    @DisplayName("자동차가 이동할 수 없는 경우 멈춘다")
    void shouldNotMoveWhenCanMoveReturnsFalse() {
        Car car = new Car("Car1", () -> false);
        int initialPosition = car.getPosition();
        car.move();
        assertEquals(initialPosition, car.getPosition());
    }

    @Test
    @DisplayName("유효하지 않은 자동차 이름이 입력되면 예외를 던진다")
    void shouldThrowExceptionForInvalidCarName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Car("CarNameTooLong", new AlwaysMoveStrategy()));
        assertThrows(IllegalArgumentException.class, () ->
                new Car("", new AlwaysMoveStrategy()));
    }
}
