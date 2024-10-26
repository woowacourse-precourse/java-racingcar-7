package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final CarService carService;

    public RacingCarController(){
        this.carService = new CarService();
    }

    public void run() {
        OutputView.requestCarNames();
        String inputCarNames = InputView.readCarNames();
        carService.createCarList(inputCarNames);
        int inputAttemptCount = InputView.readAttemptCount();
    }
}
