package racingcar.config;

import racingcar.controller.Controller;
import racingcar.view.RacingView;

public class ApplicationConfiguration {

    public Controller controller() {
        return new Controller(racingView());
    }

    public RacingView racingView() {
        return new RacingView();
    }

}
