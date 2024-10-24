package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    @Test
    @DisplayName("시도 횟수가 음수이면 예외가 발생한다")
    void validateNegativeRounds() {
        RacingGame game = new RacingGame();
        assertThatThrownBy(() -> game.validateRounds(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}