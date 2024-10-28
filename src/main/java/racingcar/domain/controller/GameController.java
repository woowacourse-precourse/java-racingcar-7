package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.Race;
import racingcar.domain.game.Winners;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final MovingStrategy strategy;

    public GameController(InputView inputView, ResultView resultView, MovingStrategy strategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.strategy = strategy;
    }

    public void play() {
        String[] carNames = inputView.getCarNames();
        int attempts = inputView.getAttempts();

        Cars cars = new Cars(List.of(carNames));
        Race race = new Race(cars, attempts);

        resultView.printStartMessage();
        race.start(strategy);
        resultView.printRaceResult(cars);

        Winners winners = new Winners(cars);
        resultView.printWinners(winners.getWinnersNames());
    }
}
