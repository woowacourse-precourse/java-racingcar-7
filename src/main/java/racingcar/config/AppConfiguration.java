package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class AppConfiguration {

    public RacingController racingController() {
        return new RacingController(racingService(), inputView(), outputView());
    }

    private RacingService racingService() {
        return new RacingService();
    }

    private RacingInputView inputView() {
        return new RacingInputView();
    }

    private RacingOutputView outputView() {
        return new RacingOutputView();
    }
}
