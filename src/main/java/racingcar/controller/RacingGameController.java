package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
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

    public void startGame() {
        List<String> carNames = racingGameView.inputCarNames();
        int attempt = racingGameView.inputAttempt();
        Cars cars = Cars.of(numberGenerator, carNames);
        Racing racing = Racing.of(cars, attempt);

        race(racing);

        List<String> winnersNames = racing.winnersNames();
        racingGameView.printWinner(winnersNames);
    }

    private void race(Racing racing) {
        racingGameView.printGameStartMessage();
        while (!racing.isFinish()) {
            racing.makeAttempt();
            racingGameView.printRacingStatus(racing.status());
        }
    }
}
