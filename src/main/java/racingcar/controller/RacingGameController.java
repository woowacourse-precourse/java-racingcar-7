package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.model.CarMaker;
import racingcar.view.InputView;

public class RacingGameController {

    private final InputView inputView;
    private final CarMaker carMaker;

    public RacingGameController(InputView inputView, CarMaker carMaker) {
        this.inputView = inputView;
        this.carMaker = carMaker;
    }

    public void start() {
        String carNames = inputView.requestCarNamesInput();
        int roundNumber = Integer.parseInt(inputView.requestRoundNumberInput());
        List<Car> carList = carMaker.makeCars(carNames);
    }
}
