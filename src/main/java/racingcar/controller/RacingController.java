package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    private final RacingService racingService;

    public RacingController(final RacingService racingService) {
        this.racingService = racingService;
    }

    public void play() {
        String inputCarNames = racingService.getInputCarName();
        int inputTotalRound = racingService.getInputTotalRound();

        racingService.addRacingCar(inputCarNames);
        racingService.playGame(inputTotalRound);

        racingService.responseGameResult();
    }
}