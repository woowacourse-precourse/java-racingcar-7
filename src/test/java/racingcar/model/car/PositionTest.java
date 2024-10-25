package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
    private final Position position = new Position();

    @Test
    @DisplayName("자동차 전진시 위치 변화 테스트")
    void movePosition() {
        final int initialPosition = position.calculateMovingDistance();

        position.increasePosition();
        position.increasePosition();
        position.increasePosition();

        final int finalPosition = position.calculateMovingDistance();

        assertEquals(3, finalPosition - initialPosition);
        assertEquals("---", position.getDistance());
    }

    @Test
    @DisplayName("자동차 멈춤시 위치 변화 테스트1")
    void stop1() {
        final int initialPosition = position.calculateMovingDistance();
        final int finalPosition = position.calculateMovingDistance();

        assertEquals(0, finalPosition - initialPosition);
        assertEquals("", position.getDistance());
    }

    @Test
    @DisplayName("자동차 멈춤시 위치 변화 테스트2")
    void stop2() {
        position.increasePosition();

        final int initialPosition = position.calculateMovingDistance();
        final int finalPosition = position.calculateMovingDistance();

        assertEquals(0, finalPosition - initialPosition);
        assertEquals("-", position.getDistance());
    }
}
