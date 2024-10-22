package racingcar.controller;

import racingcar.dto.RacingInfo;
import racingcar.dto.RacingResult;
import racingcar.model.Racing;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, RacingService racingService) {
        this.inputView = inputView;
        this.racingService = racingService;
    }

    public void run() {
        Racing racing = new Racing(readRacingInfo());

        RacingResult racingResult = racingService.racing(racing);
    }

    private RacingInfo readRacingInfo() {
        return inputView.readRacingInfo();
    }
}
