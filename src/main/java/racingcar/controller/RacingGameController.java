package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void startRace(String carNames, String tryNumber) {
        String[] inputs = InputView.getRacingCarsAndTryNumber();

        String racingCars = inputs[0];
        tryNumber = inputs[1];

        racingGameService.processRacingCars(racingCars,tryNumber);
    }
}
