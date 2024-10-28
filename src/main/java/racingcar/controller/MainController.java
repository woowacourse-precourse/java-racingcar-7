package racingcar.controller;

import racingcar.model.cars.Cars;
import racingcar.model.racerounds.RaceRounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {
    InputView inputView = InputView.getInstance();
    OutputView outputView = OutputView.getInstance();

    RaceController raceController = new RaceController();

    public void run() {
        String carNamesInput = inputView.inputCarNames();
        String roundsInput = inputView.inputRaceRounds();

        Cars cars = new Cars(carNamesInput);
        RaceRounds rounds = RaceRounds.from(roundsInput);
        raceController.race(cars, rounds);

        outputView.printResultByRound(cars);
        outputView.printWinners(cars);
    }
}
