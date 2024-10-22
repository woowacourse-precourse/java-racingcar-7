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

        displayResults(tryCount, cars);
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

    private void displayResults(int tryCount, List<Car> cars) {
        for (int i = 0; i < tryCount; i++) {
            carService.move(cars);
            OutputView.printResult(cars);
        }

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
