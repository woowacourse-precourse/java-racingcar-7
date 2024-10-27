package racingcar.controller;

import racingcar.service.RacingGameService;

public class RacingCarController {
    private final InputController inputController;
    private final RacingGameService racingGameService;

    public RacingCarController(InputController inputController, RacingGameService racingGameService) {
        this.inputController = inputController;
        this.racingGameService = racingGameService;
    }

    public void run() {
        String[] carNames = inputController.getCarNames();
        int tryCount = inputController.getTryCounts();

        racingGameService.initialize(carNames, tryCount);
        racingGameService.startRace();
        String winners = racingGameService.getWinners();
        System.out.println("최종 우승자 : " + winners);
    }
}
