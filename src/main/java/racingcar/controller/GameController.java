package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.service.impl.RacingCarServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private InputController inputController = new InputController();
    private OutputView outputView;
    private RacingCarService racingCarService;
    private List<Car> cars;
    private Integer attemptCount;

    public void run() {
        initCar();
        initAttemptCount();
        racingCarService = new RacingCarServiceImpl(cars, attemptCount);
        outputView = new OutputView(racingCarService);
        startRace();
        announceWinner();
    }

    private void initCar() {
        this.cars = inputController.initCars();
    }

    private void initAttemptCount() {
        this.attemptCount = inputController.initAttemptCount();
    }

    private void startRace() {
        outputView.startRace();
    }

    private void announceWinner() {
        outputView.getFinalWinner();
    }
}
