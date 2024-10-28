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
    private final CarFactory carFactory;
    private final WinnerDeterminer winnerDeterminer;

    public MainController(InputView inputView, OutputView outputView, Validator validator, CarFactory carFactory, WinnerDeterminer winnerDeterminer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.carFactory = carFactory;
        this.winnerDeterminer = winnerDeterminer;
    }

    public void startRace() {
        String carNames = inputView.inputCarName();
        String carRoundCount = inputView.inputCarRoundCount();

        validator.validateAllInput(carNames, carRoundCount);

        List<Car> cars = carFactory.createCarsFromInput(carNames);
        int carRound = Integer.parseInt(carRoundCount);

        RaceManager raceManager = new RaceManager(cars, carRound);
        raceManager.playAllRounds(outputView);

        List<Car> carsAtFinish = raceManager.getCars();
        List<Car> winners = winnerDeterminer.determineWinner(carsAtFinish);
        outputView.displayWinners(winners);
    }
}
