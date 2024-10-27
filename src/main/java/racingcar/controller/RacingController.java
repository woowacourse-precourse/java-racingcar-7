package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.utils.Utils;
import racingcar.validator.CarNameValidator;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final RacingService racingService = new RacingService();
    private final List<Car> cars = new ArrayList<>();

    public void run() {
        String carNames = inputCarNames();
        int tryNumber = inputTryNumber();

        cars.addAll(initializeCars(carNames));
        racingService.startRace(cars, tryNumber);

        List<String> winners = racingService.getWinners(cars);
        OutputView.printWinner(winners);
    }

    private String inputCarNames() {
        String carNames = InputView.inputCarNames();
        InputValidator.validateEmpty(carNames);
        return carNames;
    }

    private int inputTryNumber() {
        String tryNumber = InputView.inputTryNumber();
        InputValidator.validateInteger(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    private List<Car> initializeCars(String carNames) {
        List<String> carList = Utils.splitByDelimiter(carNames);
        return carList.stream()
                .peek(CarNameValidator::validateCarName)
                .map(Car::new)
                .toList();
    }
}