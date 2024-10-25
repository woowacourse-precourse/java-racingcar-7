package racingcar.controller;

import java.util.List;
import racingcar.domain.CarName;
import racingcar.domain.CarNameParser;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    private Cars makeCars(){
        return new Cars(getCarNames());
    }

    private List<CarName> getCarNames() {
        return CarNameParser.parseCarNames(inputView.getCarName());
    }
}
