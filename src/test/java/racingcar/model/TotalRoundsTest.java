package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.model.ExceptionMessages.TotalRounds.TOTAL_ROUNDS_ABOVE_MAXIMUM;
import static racingcar.model.ExceptionMessages.TotalRounds.TOTAL_ROUNDS_BELOW_MINIMUM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.game.TotalRounds;

public class TotalRoundsTest {

    private static final int MAX_TOTAL_ROUNDS = 10;
    private static final int MIN_TOTAL_ROUNDS = 1;

    @Test
    @DisplayName("최대 라운드 수를 초과하는 경우 예외를 던진다.")
    void throwExceptionWhenTotalRoundsExceedsMaxTotalRounds() {
        // given
        int invalidTotalRounds = MAX_TOTAL_ROUNDS + 1;

        // when & then
        assertThatThrownBy(() -> new TotalRounds(invalidTotalRounds))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOTAL_ROUNDS_ABOVE_MAXIMUM);
    }

    @Test
    @DisplayName("최소 라운드 수보다 작은 경우 예외를 던진다.")
    void throwExceptionWhenTotalRoundsIsLessThanMinimum() {
        // given
        int invalidTotalRounds = MIN_TOTAL_ROUNDS - 1;

        // when & then
        assertThatThrownBy(() -> new TotalRounds(invalidTotalRounds))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOTAL_ROUNDS_BELOW_MINIMUM);
    }

}
