package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {

    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.racingCarService = racingCarService;
    }

    public void run() {

    }
}
