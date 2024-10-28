package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    public void run() {
        String[] carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        RacingGame game = new RacingGame(cars);
        for (int i = 0; i < tryCount; i++) {
            List<Car> roundCars = game.playRound();
            ResultView.printRoundResults(roundCars);
        }

        List<String> winners = game.getWinners();
        ResultView.printWinners(winners);
    }
}

