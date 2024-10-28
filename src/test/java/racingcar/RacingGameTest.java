package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("주어진 시도 횟수만큼 게임이 진행되고 라운드 결과가 저장되는지 테스트")
    void testPlay() {
        List<String> carNames = List.of("Alpha", "Bravo", "Choco");
        int attemptNumber = 3;
        RacingGame racingGame = new RacingGame(carNames);

        racingGame.play(attemptNumber);

        List<RoundResult> roundResults = racingGame.getRoundResults();
        assertThat(roundResults).hasSize(3);
    }

    @Test
    @DisplayName("우승자가 올바르게 판별되는지 테스트")
    void testFindWinners() {
        List<String> carNames = List.of("Alpha", "Bravo", "Choco");
        RacingGame racingGame = new RacingGame(carNames);

        assertRandomNumberInRangeTest(() -> racingGame.play(1),
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
        assertRandomNumberInRangeTest(() -> racingGame.play(1),
                STOP, MOVING_FORWARD, MOVING_FORWARD);

        List<String> winners = racingGame.findWinners();

        assertThat(winners).containsExactly("Bravo", "Choco");
    }
}