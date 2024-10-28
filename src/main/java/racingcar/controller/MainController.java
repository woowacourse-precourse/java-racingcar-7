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
    public void run() {
        String CarNames = inputView.inputCarName();
        String CarRoundCount = inputView.inputCarRoundCount();

        validator.validateAllInput(CarNames, CarRoundCount);

        List<Car> cars = CarFactory.createCarsFromInput(CarNames);
        int carRoundCount = Integer.parseInt(CarRoundCount);

        RaceManager raceManager = new RaceManager(cars, carRoundCount);
        raceManager.playAllRounds(outputView);

        List<Car> carsAtFinish = raceManager.getCars();
        WinnerDeterminer winnerDeterminer = new WinnerDeterminer(carsAtFinish);

        List<Car> winners = winnerDeterminer.determineWinner();
        outputView.displayWinners(winners);
    }
}
