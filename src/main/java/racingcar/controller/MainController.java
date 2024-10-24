package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.InputView;

public class MainController {
    private MainController() {
    }

    public static MainController create() {
        return new MainController();
    }

    public void run() {
        String carNameInput = InputView.readCarNameInput();
        List<String> carStrings = convertToStrings(carNameInput);
        List<Car> cars = convertToCars(carStrings);
        Racing racing = Racing.create(cars);

        String trialNumberInput = InputView.readTrialNumberInput();
        int trialNumber = Integer.parseInt(trialNumberInput);
    }

    private List<String> convertToStrings(String carNameInput) {
        return Arrays.stream(carNameInput.split(","))
                .map(String::trim)
                .toList();
    }

    private List<Car> convertToCars(List<String> carStrings) {
        return carStrings.stream().map(Car::create).toList();
    }

}
