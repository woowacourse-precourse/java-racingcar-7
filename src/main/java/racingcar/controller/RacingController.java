package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final OutputView outputView = new OutputView();

    public RacingController() {
        InputView inputView = new InputView();
        RacingService racingService = new RacingService(inputView.getCarList(), inputView.getTryNumber());
    }

}
