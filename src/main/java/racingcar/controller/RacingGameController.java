package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.Racing;
import racingcar.util.NumberGenerator;
import racingcar.view.RacingGameView;

public class RacingGameController {
    private final NumberGenerator numberGenerator;
    private final RacingGameView racingGameView;

    public RacingGameController(NumberGenerator numberGenerator, RacingGameView racingGameView) {
        this.numberGenerator = numberGenerator;
        this.racingGameView = racingGameView;
    }

    public void start() {
        List<String> carNames = racingGameView.getCarNames();
        int attempt = racingGameView.getAttemptCount();
        Racing racing = Racing.of(numberGenerator, attempt, carNames);

        racingGameView.printGameStartMessage();
        race(racing);

        List<String> winnersNames = racing.getWinnersNames();
        racingGameView.printWinner(winnersNames);
    }


    private void race(Racing racing) {
        while (!racing.isFinished()) {
            racing.race();
            Map<String, Integer> status = racing.getStatus();
            racingGameView.printRacingStatus(status);
        }
    }
}
