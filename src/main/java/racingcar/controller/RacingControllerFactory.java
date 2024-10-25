package racingcar.controller;

import racingcar.domain.CarManager;
import racingcar.domain.Racing;
import racingcar.view.OutputView;

public class RacingControllerFactory {

    public static RacingController create() {
        CarManager carManager = new CarManager();
        Racing racing = new Racing();
        OutputView outputView = new OutputView();
        return new RacingController(racing, carManager, outputView);
    }

}
