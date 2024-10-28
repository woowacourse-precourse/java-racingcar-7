package racingcar.domain.racer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racer.movecondition.Condition;

class ConditionTest {

    @Test
    @DisplayName("무작위 값이 0일 때는 전진할 수 없다")
    void givenZeroGenerator_whenCanMoveForward_thenReturnFalse() {
        // given
        Condition condition = new Condition(() -> 0);

        // when
        boolean result = condition.canMoveForward();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("무작위 값이 4미만 일 때는 전진할 수 없다")
    void givenThreeGenerator_whenCanMoveForward_thenReturnFalse() {
        // given
        Condition condition = new Condition(() -> 3);

        // when
        boolean result = condition.canMoveForward();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("무작위 값이 4이상 일 때는 전진할 수 있다")
    void givenFourGenerator_whenCanMoveForward_thenReturnTrue() {
        // given
        Condition condition = new Condition(() -> 4);

        // when
        boolean result = condition.canMoveForward();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("무작위 값이 9 일 때는 전진할 수 있다")
    void givenNineGenerator_whenCanMoveForward_thenReturnTrue() {
        // given
        Condition condition = new Condition(() -> 9);

        // when
        boolean result = condition.canMoveForward();

        // then
        assertThat(result).isTrue();
    }

}