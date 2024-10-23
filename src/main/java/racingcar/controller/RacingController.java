package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RacingService racingService = new RacingService();

    public RacingController() {
        racingService.start(inputView.getCarNameList(), inputView.getTryNumber());
    }
}
