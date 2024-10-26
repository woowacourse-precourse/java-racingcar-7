package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {

    private final RacingService racingcarService;

    public RacingController(final RacingService racingcarService) {
        this.racingcarService = racingcarService;
    }

    public void play() {
        String inputCarNames = racingcarService.getInputCarName();
        int inputTotalRound = Integer.parseInt(racingcarService.getInputTotalRound());

        racingcarService.addRacingCar(inputCarNames);
        racingcarService.playGame(inputTotalRound);
    }
}