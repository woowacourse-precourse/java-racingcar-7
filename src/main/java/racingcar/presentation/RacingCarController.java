package racingcar.presentation;

import racingcar.application.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        racingCarService.run();
    }
}
