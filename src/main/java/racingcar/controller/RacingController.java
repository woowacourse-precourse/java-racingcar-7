package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.utils.Utils;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final RacingService racingService = new RacingService();
    private final List<Car> cars = new ArrayList<>();

    public void run() {
        cars.addAll(inputCarName());
        int tryNumber = InputView.inputTryNumber();

        racingService.startRace(cars, tryNumber);

        List<String> winners = racingService.getWinners(cars);
        OutputView.printWinner(winners);
    }

    private List<Car> inputCarName() {
        String input = InputView.inputCarNames();
        List<String> carList = Utils.splitDelimiterCars(input);
        return initializeCars(carList);
    }

    private List<Car> initializeCars(List<String> carList) {
        return carList.stream()
                .peek(InputValidator::validateNameLength)
                .map(Car::new)
                .toList();
    }
}