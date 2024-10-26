package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.view.RacingView;

public class AppConfiguration {

    public RacingController racingController() {
        return new RacingController(racingView());
    }

    private RacingView racingView() {
        return new RacingView();
    }
}
