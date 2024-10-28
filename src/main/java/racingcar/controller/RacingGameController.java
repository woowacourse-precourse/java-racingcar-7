package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void runGame() {
        OutputView.printCarNamePrompt();
        List<String> carNames = InputView.inputCarNames();
        List<Car> cars = carNames.stream().map(Car::new).toList();

        OutputView.printTryCountPrompt();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(cars, tryCount);

        racingGame.start();

        List<Car> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}
