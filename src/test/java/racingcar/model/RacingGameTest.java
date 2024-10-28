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

    @Test
    @DisplayName("남은 라운드 수가 0 일 경우 게임 진행 시 오류 발생")
    void gameEndTest() {
        // given
        RacingGame racingGame = new RacingGame(1);
        racingGame.playRound();

        // when & then
        assertThatThrownBy(racingGame::playRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingGameException.GAME_IS_END.getMessage());
    }
}