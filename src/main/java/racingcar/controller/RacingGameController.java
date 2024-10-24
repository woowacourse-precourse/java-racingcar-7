package racingcar.controller;

import racingcar.service.RacingGameService;

public class RacingGameController {
    private RacingGameService racingGameService = new RacingGameService();
    public void start() {
        racingGameService.inputCars();
        racingGameService.inputMoveCount();
        racingGameService.race();
        racingGameService.announceWinners();
    }

    private void announceWinners() {
    }

    private void race() {
    }

    private void inputMoveCount() {
        
    }

    private void inputCars() {
        
    }


}
