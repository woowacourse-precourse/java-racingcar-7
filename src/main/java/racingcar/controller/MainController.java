package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.service.RaceManager;
import racingcar.service.WinnerDeterminer;
import racingcar.validator.Validator;
import racingcar.view.View;

import java.util.Arrays;
import java.util.List;

public class MainController {
    private final View view = new View();
    private final Validator validator = new Validator();

    public void run() {
        String inputCarNames = view.inputCarName();
        String inputCarRoundCount = view.inputCarRoundCount();

        validator.validateAllInput(inputCarNames, inputCarRoundCount);

        List<Car> cars = CarFactory.createCarsFromInput(inputCarNames);
        int carRoundCount = Integer.parseInt(inputCarRoundCount);

        RaceManager raceManager = new RaceManager(view, cars, carRoundCount);
        raceManager.playRoundUntilRoundCount();

        WinnerDeterminer winnerDeterminer = new WinnerDeterminer(raceManager);
        List<Car> winners = winnerDeterminer.determineWinner();

        view.displayWinners(winners);
    }
}
