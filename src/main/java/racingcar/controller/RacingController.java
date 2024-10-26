package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class RacingController {

    private InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void startRacing() {
        List<Car> cars = prepareRacingCar();
        int roundCount = prepareRoundCount();
    }

    private List<Car> prepareRacingCar() {
        String rawCarNames = inputView.inputCarNames();
        List<String> carNames = List.of(rawCarNames.split(","));
        return carNames.stream().map(Car::new).toList();
    }

    private int prepareRoundCount() {
        String rawRoundCount = inputView.inputRoundCount();
        return Integer.parseInt(rawRoundCount);
    }
}
