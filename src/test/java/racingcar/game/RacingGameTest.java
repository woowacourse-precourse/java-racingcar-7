package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.game.constant.ExceptionMessage.INVALID_RACING_COUNT_RANGE;

class RacingGameTest {
    private RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("잘못된 경주 횟수 입력 시 예외 발생")
    public void testRunWithInvalidRacingCount(int racingCount) {
        assertThatThrownBy(() -> racingGame.validateRacingCount(racingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RACING_COUNT_RANGE.getMessage());
    }
}