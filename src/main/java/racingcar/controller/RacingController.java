package racingcar.controller;

import racingcar.dto.RacingInfo;
import racingcar.dto.RacingResult;
import racingcar.model.Racing;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        Racing racing = new Racing(readRacingInfo());

        RacingResult racingResult = racingService.racing(racing);

        printRacingResult(racingResult);
    }

    private RacingInfo readRacingInfo() {
        return inputView.readRacingInfo();
    }

    private void printRacingResult(RacingResult racingResult) {
        outputView.printRacingResult(racingResult);
    }
}
