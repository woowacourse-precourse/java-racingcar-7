package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void startRace(String carNames, String tryNumber) {
        racingGameService.processRacingCars(carNames,tryNumber);
    }
}
