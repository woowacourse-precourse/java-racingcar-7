package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    public void run() {
        String[] carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        List<Car> cars = Car.generate(carNames);
        RacingGame game = new RacingGame(cars);

        for (int i = 0; i < tryCount; i++) {
            List<Car> roundCars = game.playRound();
            ResultView.printRoundResults(roundCars);
        }

        List<String> winners = game.getWinners();
        ResultView.printWinners(winners);
    }
}

