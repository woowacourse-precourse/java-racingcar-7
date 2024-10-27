package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import racingcar.exceptions.InvalidRoundValueException;

public class RoundTest {

    @Test
    public void 초기화_테스트() {
        // given
        Round round = new Round();

        // when
        int currentRound = round.getRound();

        // then
        assertThat(currentRound).isEqualTo(0);
    }

    @Test
    public void 라운드_업데이트_테스트() {
        // given
        Round round = new Round();

        // when
        round.updateRound(2);

        // then
        assertThat(round.getRound()).isEqualTo(2);
    }

    @Test
    public void 라운드_업데이트_예외_테스트() {
        // given
        Round round = new Round();

        // when & then
        assertThatExceptionOfType(InvalidRoundValueException.class)
                .isThrownBy(() -> round.updateRound(0));
    }
}
