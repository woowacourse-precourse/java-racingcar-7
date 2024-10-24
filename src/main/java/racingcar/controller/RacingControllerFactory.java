package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.utils.StringSplitter;
import racingcar.view.OutputView;

public class RacingControllerFactory {

    public static RacingController create() {
        Cars cars = new Cars(new ArrayList<>());
        Racing racing = new Racing(cars);
        StringSplitter stringSplitter = new StringSplitter();
        OutputView outputView = new OutputView();
        return new RacingController(racing, cars, stringSplitter, outputView);
    }

}
