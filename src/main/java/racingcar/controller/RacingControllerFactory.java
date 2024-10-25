package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.CarManager;
import racingcar.domain.Racing;
import racingcar.utils.StringSplitter;
import racingcar.view.OutputView;

public class RacingControllerFactory {

    public static RacingController create() {
        CarManager carManager = new CarManager(new ArrayList<>());
        Racing racing = new Racing(carManager);
        StringSplitter stringSplitter = new StringSplitter();
        OutputView outputView = new OutputView();
        return new RacingController(racing, carManager, stringSplitter, outputView);
    }

}
