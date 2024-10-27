package racingcar;

import java.util.List;
import racingcar.car.Cars;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.number.generator.NumberGenerator;
import racingcar.number.generator.RandomNumberGenerator;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final Judgment judgment;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
        judgment = new Judgment();
    }

    public void start() {
        String[] carName = readCarName();
        Cars cars = putCars(carName);
        int movementNumber = readMovementNumber();
        moveCar(cars, movementNumber);
        List<String> winner = makeWinnerList(cars);
        printWinner(winner);
    }

    private void printWinner(List<String> winner) {
        outputView.printWinner(winner);
    }

    private List<String> makeWinnerList(Cars cars) {
        return judgment.makeWinnerNameList(cars);
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
        outputView.printMovementResultMessage();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < movementNumber; i++) {
            cars.move(numberGenerator);
            printCarState(cars);
        }
    }

    private void printCarState(Cars cars) {
        outputView.printCarStatement(cars);
    }

}
