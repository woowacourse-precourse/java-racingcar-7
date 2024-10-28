package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.Validator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    final InputView inputView = new InputView(new Validator());
    final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInputCarNamesMessage();
        List<String> carNames = inputView.readCarNames();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        outputView.printInputTryCountMessage();
        int roofCount = inputView.readRoofCount();

        final RacingGame racingGame = new RacingGame(cars, roofCount);
        racingGame.startRacing();

        Winner winner = new Winner();
        winner.addWinner(cars);

        outputView.printFinalWinner(winner);
    }
}
