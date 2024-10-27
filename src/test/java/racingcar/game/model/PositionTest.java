package racingcar.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private final Position position = new Position();
    @Test
    @DisplayName("위치 이동 성공 케이스")
    void movePosition_ValidCondition() {
        position.move(4);
        assertEquals(1, position.getPosition());
    }

    @Test
    @DisplayName("위치 이동 실패 케이스")
    void movePosition_InvalidCondition() {
        position.move(3);
        assertEquals(0, position.getPosition());
    }
}