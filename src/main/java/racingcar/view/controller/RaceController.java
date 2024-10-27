package racingcar.view.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.domain.Car;
import racingcar.view.domain.Cars;

public class RaceController {

    private final InputView inputView;

    public RaceController() {
        inputView = new InputView();
    }

    public void start() {
        String inputCarsString = inputView.requestCarsName();
        Cars cars = new Cars(Arrays.stream(inputCarsString.split(",")).map(Car::new).toList());
    }

}
