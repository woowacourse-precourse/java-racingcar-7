package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingGameException;

class RacingGameTest {

    @Test
    @DisplayName("RacingGame Round가 1 미만일 경우 RacingGameException 발생")
    void lessThanOneRoundTest() {
        // given
        int round = 0;

        // when & then
        assertThatThrownBy(() -> new RacingGame(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingGameException.ROUND_IS_LESS_THAN_ONE.getMessage());
    }
}