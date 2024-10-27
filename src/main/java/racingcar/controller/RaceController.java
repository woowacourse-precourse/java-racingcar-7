package racingcar.controller;

import java.util.Arrays;
import racingcar.view.InputView;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RaceController {

    private final InputView inputView;

    public RaceController() {
        inputView = new InputView();
    }

    public void start() {
        String inputCarsString = inputView.requestCarsName();
        Cars cars = new Cars(Arrays.stream(inputCarsString.split(",")).map(Car::new).toList());

        int roundCount = inputView.requestRoundCount();
    }

}
