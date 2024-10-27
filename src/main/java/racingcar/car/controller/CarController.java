package racingcar.car.controller;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.service.CarService;
import racingcar.global.io.InputView;
import racingcar.global.io.OutputView;
import racingcar.global.util.ErrorMessage;
import racingcar.global.util.TryCountValid;

public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void start() {
        initializeCars();
        int tryCount = retrieveTryCount();

        List<Car> cars = carService.getCars();

        moveCars(tryCount, cars);

        displayResult(cars);
    }

    private void initializeCars() {
        String inputCarNames = InputView.printCarNames();
        carService.create(inputCarNames);
    }

    private int retrieveTryCount() {
        String inputTryCount = InputView.printTryCount();
        int tryCount = convertStringToInt(inputTryCount);
        TryCountValid.validateRange(tryCount);
        return tryCount;
    }

    private void moveCars(int tryCount, List<Car> cars) {
        OutputView.printResultHeader();
        for (int i = 0; i < tryCount; i++) {
            carService.move(cars);
            OutputView.printCarPositions(cars);
        }
    }

    private void displayResult(List<Car> cars) {
        OutputView.printWinner(cars);
    }


    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}
