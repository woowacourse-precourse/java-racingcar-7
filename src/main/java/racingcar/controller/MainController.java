package racingcar.controller;

import racingcar.domain.Car;
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
        String inputCarName = view.inputCarName();
        String inputCarRoundCount = view.inputCarRoundCount();

        validator.validateAllInput(inputCarName, inputCarRoundCount);

        List<Car> cars = Arrays.stream(inputCarName.split(","))
                .map(Car::new)
                .toList();

        int carRoundCount = Integer.parseInt(inputCarRoundCount);

        RaceManager raceManager = new RaceManager(view, cars, carRoundCount);
        raceManager.playRoundUntilRoundCount();

        WinnerDeterminer winnerDeterminer = new WinnerDeterminer(raceManager);
        List<Car> winners = winnerDeterminer.determineWinner();

        view.displayWinners(winners);
    }
}
