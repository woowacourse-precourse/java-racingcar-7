package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.RacingView;

public class AppConfiguration {

    public RacingController racingController() {
        return new RacingController(racingService(), racingView());
    }

    private RacingService racingService() {
        return new RacingService();
    }

    private RacingView racingView() {
        return new RacingView();
    }
}
