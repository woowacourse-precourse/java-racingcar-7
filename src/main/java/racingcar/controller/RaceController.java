package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceGame;
import racingcar.util.RaceCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final Cars cars;
    private final RaceGame raceGame;


    public RaceController(Cars cars, RaceGame raceGame) {
        this.cars = cars;
        this.raceGame = raceGame;

    }

    public void run() {

        InputView.printEnterCarNames();
        String enteredCarNames = InputView.getInput();

        List<Car> racingCars = cars.extractValidCars(enteredCarNames);

        InputView.printEnterRaceCount();
        String raceCountInput = InputView.getInput();

        RaceCountValidator.validate(raceCountInput);
        int raceCount = Integer.parseInt(raceCountInput);

        OutputView.printGameResultMessage();

        String winners = raceGame.playGame(racingCars, raceCount);
        OutputView.printWinner(winners);
    }


}


