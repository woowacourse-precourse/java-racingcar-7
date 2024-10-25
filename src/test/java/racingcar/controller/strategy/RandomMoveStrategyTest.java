package racingcar.controller.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RandomMoveStrategyTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("무작위 값이 이동 가능한 값 이상일 때 움직일 수 있다")
        void testCanMove() {
            // given
            int minValue = 0;
            int maxValue = 9;
            int movableValue = 0;
            RandomMoveStrategy moveStrategy = new RandomMoveStrategy(minValue, maxValue, movableValue);

            // when & then
            assertThat(moveStrategy.isMovable()).isTrue();
        }

        @Test
        @DisplayName("무작위 값이 이동 가능한 값보다 작을 때 움직일 수 없다")
        void testDoesNotMove() {
            // given
            int minValue = 0;
            int maxValue = 9;
            int movableValue = 10;
            RandomMoveStrategy moveStrategy = new RandomMoveStrategy(minValue, maxValue, movableValue);

            // when & then
            assertThat(moveStrategy.isMovable()).isFalse();
        }
    }
}
