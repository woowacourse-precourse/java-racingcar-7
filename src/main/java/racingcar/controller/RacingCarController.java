package racingcar.controller;

import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final CarService carService;
    private final RacingService racingService;

    public RacingCarController(){
        this.carService = new CarService();
        this.racingService = new RacingService(carService);
    }

    public void run() {
        OutputView.requestCarNames();
        String inputCarNames = InputView.readCarNames();
        carService.createCarList(inputCarNames);

        OutputView.requestAttemptCount();
        int attemptCount = InputView.readAttemptCount();
        racingService.raceStart(attemptCount);
    }
}
