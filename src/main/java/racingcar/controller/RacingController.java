package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private OutputView outputView;
    private RacingService racingService;

    public RacingController() {
        InputView inputView = new InputView();
        racingService.start(inputView.getCarNameList(), inputView.getTryNumber());

        outputView = new OutputView();
        racingService = new RacingService();
    }

}
