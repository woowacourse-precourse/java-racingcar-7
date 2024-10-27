package racingcar;

import racingcar.car.Cars;
import racingcar.io.InputView;

public class GameManager {
    private final InputView inputView;

    public GameManager() {
        this.inputView = new InputView();
    }

    public void start() {
        String[] carName = readCarName();
        Cars cars = putCars(carName);
        int movementNumber = readMovementNumber();
    }

    private int readMovementNumber() {
        return inputView.readMovementNumber();
    }

    private Cars putCars(String[] carName) {
        Cars cars = new Cars();
        for (String name : carName) {
            cars.addCar(name);
        }
        return cars;
    }

    private String[] readCarName() {
        return inputView.readCarName();
    }

}
