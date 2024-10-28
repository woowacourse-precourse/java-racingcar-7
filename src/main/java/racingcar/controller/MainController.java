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
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;

    public MainController(InputView inputView, OutputView outputView, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }
    public void startRace() {
        String carNames = inputView.inputCarName();
        String carRoundCount = inputView.inputCarRoundCount();

        validator.validateAllInput(carNames, carRoundCount);

        List<Car> cars = CarFactory.createCarsFromInput(carNames);
        int carRound = Integer.parseInt(carRoundCount);

        RaceManager raceManager = new RaceManager(cars, carRound);
        raceManager.playAllRounds(outputView);

        List<Car> carsAtFinish = raceManager.getCars();
        List<Car> winners = WinnerDeterminer.determineWinner(carsAtFinish);
        outputView.displayWinners(winners);
    }
}
