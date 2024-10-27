package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.List;

public class GameController {
    InputController inputController = new InputController();
    private List<Car> cars;
    private Integer attemptCount;

    public void run() {
        initCar();
        initAttemptCount();
    }

    private void initCar() {
        this.cars = inputController.initCars();
    }

    private void initAttemptCount() {
        this.attemptCount = inputController.initAttemptCount();
    }
}
