package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        String inputCarNames = inputView.getNameOfCars();
        String[] carNames = inputCarNames.split(DELIMITER);
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }

        int attemptCount = inputView.getAttemptCount();
    }
}
        