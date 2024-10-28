package racingcar.controller;

import racingcar.service.RacingcarService;
import racingcar.view.RacingcarView;

public class RacingcarController {

    private RacingcarView racingcarView;
    private RacingcarService racingcarService;

    public RacingcarController(RacingcarView racingcarView, RacingcarService racingcarService) {
        this.racingcarView = racingcarView;
        this.racingcarService = racingcarService;
    }

    public void run() {
        
    }
}
