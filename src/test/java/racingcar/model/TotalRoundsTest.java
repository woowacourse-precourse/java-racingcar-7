package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.game.TotalRounds;

public class TotalRoundsTest {

    private static final int MAX_TOTAL_ROUNDS = 10;

    @Test
    @DisplayName("최대 라운드 수를 초과하는 경우 예외를 던진다.")
    void throwExceptionWhenTotalRoundsExceedsMaxTotalRounds() {
        // given
        int invalidTotalRounds = MAX_TOTAL_ROUNDS + 1;

        // when & then
        assertThatThrownBy(() -> new TotalRounds(invalidTotalRounds))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 라운드 수는 10회 이하여야 합니다.");
    }
}
