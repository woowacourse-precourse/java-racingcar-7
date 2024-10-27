package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMoveStrategyTest {

    @Test
    @DisplayName("랜덤 숫자가 움직임 기준값(4) 이상일 때 테스트")
    void aboveMoveThreshold() {
        // given (고정값 5)
        RandomNumberGenerator numberGenerator = new FixedNumberGenerator(5);
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(numberGenerator);

        // when
        boolean result = randomMoveStrategy.isMovable();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("랜덤 숫자가 움직임 기준값(4) 미만일 때 테스트")
    void belowMoveThreshold() {
        // given (고정값 3)
        RandomNumberGenerator numberGenerator = new FixedNumberGenerator(3);
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(numberGenerator);

        // when
        boolean result = randomMoveStrategy.isMovable();

        // then
        assertThat(result).isFalse();
    }
}
