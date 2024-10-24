package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final OutputView outputView = new OutputView();
    private RacingService racingService;

    public RacingController() {
        InputView inputView = new InputView();
        racingService = new RacingService(inputView.getCarList(), inputView.getTryNumber());
        racingService.start();
        outputView.printRoundOutput(racingService.getCarToRacingProgress());
    }


}
