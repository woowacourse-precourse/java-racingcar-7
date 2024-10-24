package racingcar.config;

import racingcar.controller.RacingGameController;
import racingcar.model.CarMaker;
import racingcar.view.InputView;

public class AppConfig {

    public RacingGameController racingGameController() {
        return new RacingGameController(new InputView(), new CarMaker());
    }
}
