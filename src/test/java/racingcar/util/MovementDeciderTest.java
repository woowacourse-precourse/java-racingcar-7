package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovementDeciderTest {
    @DisplayName("이동 성공")
    @Test
    void canMove() {
        assertRandomNumberInRangeTest(
                () -> assertTrue(MovementDecider.tryMove()), 5
        );
    }

    @DisplayName("이동 실패")
    @Test
    void notMove() {
        assertRandomNumberInRangeTest(
                () -> assertFalse(MovementDecider.tryMove()), 1
        );
    }
}