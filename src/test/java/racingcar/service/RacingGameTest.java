package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;

class RacingGameTest {
    private static final AlwaysThreeNumberGenerator three = new AlwaysThreeNumberGenerator();
    private static final AlwaysFourNumberGenerator four = new AlwaysFourNumberGenerator();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 한칸_전진_테스트() {
        // given
        Player testPlayer = new Player("kinopio", 0);
        RacingGame racingGame = new RacingGame(List.of(testPlayer), 1);

        // when
        racingGame.moveCarByRule(testPlayer, four);

        // then
        Assertions.assertThat(
                testPlayer.getPosition()
        ).isEqualTo(1);
    }

    @Test
    void 정지_테스트() {
        // given
        Player testPlayer = new Player("kinopio", 0);
        RacingGame racingGame = new RacingGame(List.of(testPlayer), 1);

        // when
        racingGame.moveCarByRule(testPlayer, three);

        // then
        Assertions.assertThat(
                testPlayer.getPosition()
        ).isEqualTo(0);
    }

    @Test
    void 승자_테스트() {
        // given
        List<Player> testPlayers = List.of(new Player("mario", 0), new Player("luigi", 0), new Player("kinopio", 0));

        RacingGame racingGame = new RacingGame(testPlayers, 1);

        // when & then
        racingGame.moveCarByRule(testPlayers.get(0), three);
        racingGame.moveCarByRule(testPlayers.get(1), four);
        racingGame.moveCarByRule(testPlayers.get(2), three);

        Assertions.assertThat(racingGame.getWinners().get(0))
                .isEqualTo("luigi");
    }
}