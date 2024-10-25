package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputHandler;
import camp.nextstep.edu.missionutils.Console;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }
}
