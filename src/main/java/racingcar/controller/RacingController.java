package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceGame;
import racingcar.validation.CarNamesValidation;
import racingcar.validation.RaceCountsValidation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarNamesValidation carNamesValidation = new CarNamesValidation();
    private final RaceCountsValidation raceCountsValidation = new RaceCountsValidation();

    public void run() {
        List<String> carNames = carNamesValidation.validateCarNames(inputView.readCarNames());
        int raceCount = raceCountsValidation.validateRaceCounts(inputView.readRaceCounts());

        List<Car> carObjects = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Cars cars = new Cars(carObjects);
        RaceGame raceGame = new RaceGame(cars, raceCount);
        raceGame.startRace(outputView);
    }
}
