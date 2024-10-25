package racingcar.controller;

import racingcar.dto.RacingOutputDTO;
import racingcar.service.RacingCarService;

public class RacingController {
    private final RacingCarService racingCarService;

    public RacingController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public RacingOutputDTO run() {
        return racingCarService.racingStart();
    }


}
