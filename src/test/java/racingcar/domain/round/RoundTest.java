package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("1라운드 미만의 라운드 정보가 주어질 경우, 예외가 발생한다.")
    void givenZeroRoundInfo_whenCreatedRound_thenThrowException() {
        // given
        int roundInfo = 0;

        // when & then
        assertThatThrownBy(() -> new Round(roundInfo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1라운드 정보가 주어질 경우, 게임이 종료되지 않는다.")
    void givenOneRoundInfo_whenCreatedRound_thenIsNotGameOver() {
        // given
        int roundInfo = 1;

        // when
        Round round = new Round(roundInfo);

        // then
        assertThat(round.isNotGameOver()).isTrue();
    }

    @Test
    @DisplayName("1라운드 정보가 주어질 경우, 다음 게임을 진행하면 게임이 종료된다.")
    void givenOneRoundInfoWithCreated_whenNextGame_thenIsGameOver() {
        // given
        int roundInfo = 1;
        Round round = new Round(roundInfo);

        // when
        round.nextRound();

        // then
        assertThat(round.isNotGameOver()).isFalse();
    }

}