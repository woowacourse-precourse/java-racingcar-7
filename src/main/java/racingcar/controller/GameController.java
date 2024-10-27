package racingcar.controller;

import static racingcar.view.OutputView.printGameStart;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView;

    public GameController() {
        this.inputView = new InputView();
    }

    public void run() {
        Cars cars = setCars();
    }

    private Cars setCars() {
        printGameStart();
        List<String> carNames = inputView.getValidatedCarNames();
        List<Car> carList = carNames.stream()
                .map(Car::of)
                .toList();
        return new Cars(carList);
    }
}
