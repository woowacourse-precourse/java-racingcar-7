package racingcar;

import racingcar.car.Cars;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.number.generator.NumberGenerator;
import racingcar.number.generator.RandomNumberGenerator;

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
        moveCar(cars, movementNumber);
    }

    private int readMovementNumber() {
        outputView.printMovementNumberMessage();
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
        outputView.printCarNameMessage();
        return inputView.readCarName();
    }

    private void moveCar(Cars cars, int movementNumber) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < movementNumber; i++) {
            printCarState(cars);
            cars.move(numberGenerator);
        }
    }

    private void printCarState(Cars cars) {
        outputView.printCarStatement(cars);
    }

}
