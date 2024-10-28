package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveDeciderTest {

    private MoveDecider moveDecider;

    @BeforeEach
    void setUp() {
        moveDecider = new MoveDecider(new TestRandomNumberGenerator(4));
    }

    @Test
    @DisplayName("전진할때")
    void moveForward() {
        assertTrue(moveDecider.isMovable());
    }

    @Test
    @DisplayName("전진하지 않을때")
    void notMove() {
        moveDecider = new MoveDecider(new TestRandomNumberGenerator(3));
        assertFalse(moveDecider.isMovable());
    }
}