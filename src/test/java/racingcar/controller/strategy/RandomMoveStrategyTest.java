package racingcar.controller.strategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RandomMoveStrategyTest {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("무작위 값이 이동 가능한 값 이상일 때 움직일 수 있다")
        void testCanMove() {
            // given
            int movableValue = 4;
            RandomMoveStrategy moveStrategy = new RandomMoveStrategy(MIN_VALUE, MAX_VALUE, movableValue);

            // when & then
            assertRandomNumberInRangeTest(
                    () -> assertThat(moveStrategy.isMovable()).isTrue(),
                    movableValue, MAX_VALUE
            );
        }

        @Test
        @DisplayName("무작위 값이 이동 가능한 값보다 작을 때 움직일 수 없다")
        void testDoesNotMove() {
            // given
            int movableValue = 4;
            RandomMoveStrategy moveStrategy = new RandomMoveStrategy(MIN_VALUE, MAX_VALUE, movableValue);

            // when & then
            assertRandomNumberInRangeTest(
                    () -> assertThat(moveStrategy.isMovable()).isFalse(),
                    MIN_VALUE, movableValue - 1
            );
        }
    }
}
