package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {

    private final Cars cars;
    private final RaceGame raceGame;


    public RaceGameController(Cars cars, RaceGame raceGame) {
        this.cars = cars;
        this.raceGame = raceGame;

    }

    public void run() {

        InputView.printEnterCarNames();
        String enteredCarNames = InputView.getInput();

        List<Car> racingCars = cars.extractValidCars(enteredCarNames);

        InputView.printEnterRaceCount();
        String raceCountInput = InputView.getInput();

        String winners = raceGame.playGame(racingCars, raceCountInput);

        OutputView.printGameResultMessage();
        OutputView.printWinner(winners);
    }


}


