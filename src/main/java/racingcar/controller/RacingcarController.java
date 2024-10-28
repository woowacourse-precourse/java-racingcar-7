package racingcar.controller;

import java.util.List;
import racingcar.service.RacingcarService;
import racingcar.view.RacingcarView;

public class RacingcarController {

    private final RacingcarView racingcarView;
    private final RacingcarService racingcarService;

    public RacingcarController(RacingcarView racingcarView, RacingcarService racingcarService) {
        this.racingcarView = racingcarView;
        this.racingcarService = racingcarService;
    }

    public void run() {
        String rawCarName = racingcarView.carNameInput();
        List<String> parsedCarName = racingcarService.parseCarName(rawCarName);
        racingcarService.validateCarName(parsedCarName);

        String trialCount = racingcarView.trialCountInput();
        racingcarService.validateNumber(trialCount);
    }
}