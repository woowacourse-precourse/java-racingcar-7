package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.constants.ErrorMessage.INVALID_NUMBER;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingCarException;

class RacingGameRoundTest {

    @Test
    void 정상적인_레이싱_게임_라운드() {
        // given
        int round = 5;
        RacingGameRound gameRound = new RacingGameRound(round);

        // then
        assertThat(gameRound.getRound()).isEqualTo(5);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @NullSource
    @ValueSource(ints = {-1, 0})
    void 예외_레이싱_게임_라운드가_0_또는_음수일_경우(final Integer input) {
        // then
        assertThatThrownBy(() -> new RacingGameRound(input))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(INVALID_NUMBER.getMessage());
    }
}