// GameController.java
package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.strategy.RandomMovableStrategy;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    public void startGame() {
        List<String> carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();

        InputValidator.validateCarNames(carNames);
        InputValidator.validateRounds(rounds);

        Race race = new Race(carNames);
        RandomMovableStrategy strategy = new RandomMovableStrategy();

        for (int i = 0; i < rounds; i++) {
            race.raceRound(strategy);
            OutputView.printRaceStatus(race.getCars());
        }

        List<String> winners = race.getWinners();
        OutputView.printWinners(winners);
    }
}
