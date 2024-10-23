package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

public class GameController {
    private static final String DELIMITER = ",";

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String inputCarNames = inputView.getNameOfCars();
        String[] carNames = inputCarNames.split(DELIMITER);
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
    }
}
        