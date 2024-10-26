package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class CarRacingController {

    public static final String CAR_NAME_DELIMITER = ",";

    private final InputView inputView;

    public CarRacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carNames = inputView.inputCarNames();
        List<Car> carList = makeCarList(carNames);
    }

    private List<Car> makeCarList(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList();
    }
}
