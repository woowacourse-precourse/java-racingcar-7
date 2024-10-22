package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ValueSource(ints = {-1, 0})
    void 예외_레이싱_게임_라운드가_0_또는_음수일_경우(int input) {
        // then
        assertThatThrownBy(() -> new RacingGameRound(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}