package racingcar.controller;

import racingcar.service.RegisterService;
import racingcar.view.InputView;

public class RacingGameController {
    private final RegisterService registerService;

    public RacingGameController(RegisterService registerService) {
        this.registerService = registerService;
    }

    public void start() {
        String carNames = InputView.carNames();
        registerService.registerCars(carNames);

        setupRound();
    }

    private void setupRound() {
        String attemptCount = InputView.attemptCount();
    }

}
