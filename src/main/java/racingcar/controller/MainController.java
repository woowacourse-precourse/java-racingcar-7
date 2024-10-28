package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.service.RaceManager;
import racingcar.service.WinnerDeterminer;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    public void run() {
        String inputCarNames = inputView.inputCarName();
        String inputCarRoundCount = inputView.inputCarRoundCount();

        validator.validateAllInput(inputCarNames, inputCarRoundCount);

        List<Car> cars = CarFactory.createCarsFromInput(inputCarNames);
        int carRoundCount = Integer.parseInt(inputCarRoundCount);

        RaceManager raceManager = new RaceManager(cars, carRoundCount);
        raceManager.playRoundUntilRoundCount(outputView);

        WinnerDeterminer winnerDeterminer = new WinnerDeterminer(raceManager);
        List<Car> winners = winnerDeterminer.determineWinner();

        outputView.displayWinners(winners);
    }
}
