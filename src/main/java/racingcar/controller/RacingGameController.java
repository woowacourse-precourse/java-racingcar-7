package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.service.RegisterService;
import racingcar.service.RoundService;
import racingcar.view.InputView;

public class RacingGameController {
    private final RegisterService registerService;
    private final RoundService roundService;

    public RacingGameController(RegisterService registerService, RoundService roundService) {
        this.registerService = registerService;
        this.roundService = roundService;
    }

    public void start() {
        String carNames = InputView.carNames();
        Cars cars = registerService.registerCars(carNames);

        Round round = setupRound();
    }

    private Round setupRound() {
        String attemptCountInput = InputView.attemptCount();
        return new Round(attemptCountInput);
    }

}
