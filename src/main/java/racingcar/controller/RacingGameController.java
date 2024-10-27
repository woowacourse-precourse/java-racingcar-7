package racingcar.controller;

import racingcar.domain.Round;
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

        Round round = setupRound();
    }

    private Round setupRound() {
        String attemptCountInput = InputView.attemptCount();
        return new Round(attemptCountInput);
    }

}
