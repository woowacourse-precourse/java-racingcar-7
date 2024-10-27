package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class RoundTest {

    @Test
    public void 초기화시_라운드는_0으로_설정된다() {
        // given
        Round round = new Round();

        // when
        int currentRound = round.getRound();

        // then
        assertThat(currentRound).isEqualTo(0);
    }

    @Test
    public void updateRound_유효한_값을_입력하면_라운드가_업데이트된다() {
        // given
        Round round = new Round();

        // when
        round.updateRound(2);

        // then
        assertThat(round.getRound()).isEqualTo(2);
    }

    @Test
    public void updateRound_유효하지_않은_값을_입력하면_예외가_발생한다() {
        // given
        Round round = new Round();

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> round.updateRound(0));
    }

    @Test
    public void updateRound_1_이하의_값을_입력하면_예외가_발생한다() {
        // given
        Round round = new Round();

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> round.updateRound(0));
    }
}
