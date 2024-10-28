package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void 승리자() {
        final int winnerPoint = 1000;
        final Participant firstWinner = new Participant(new Car(CarName.of("test"), 5), winnerPoint);
        final Participant secondWinner = new Participant(new Car(CarName.of("test"), 5), winnerPoint);
        final Participant loser = new Participant(new Car(CarName.of("test"), 5), 0);

        final ProgressedAmountRepository repository = new ProgressedAmountRepository();
        final Game game = new Game(List.of(firstWinner, secondWinner, loser), repository, new MoveConditionGenerator());
        game.run(0);

        Assertions.assertThat(game.getWinners())
                .isEqualTo(new Winners(List.of(firstWinner.getInfo(), secondWinner.getInfo())));
    }
}