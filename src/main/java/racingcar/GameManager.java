package racingcar;

import racingcar.car.Cars;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
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
        outputView.printReadCarNameMessage();
        return inputView.readCarName();
    }

}
