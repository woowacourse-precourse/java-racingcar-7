package racingcar.controller;

import static racingcar.view.OutputView.printGameStart;
import static racingcar.view.OutputView.printTryCount;

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
        int tryCount = setTryCount();
    }

    private Cars setCars() {
        printGameStart();
        List<String> carNames = inputView.getCarNames();
        List<Car> carList = carNames.stream()
                .map(Car::of)
                .toList();
        return new Cars(carList);
    }

    private int setTryCount() {
        printTryCount();
        return inputView.getTryCount();
    }
}
