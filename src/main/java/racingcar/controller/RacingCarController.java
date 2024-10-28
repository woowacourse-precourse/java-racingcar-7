package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.util.StringUtils;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView();
    }

    public void run() {
        String carNamesInput = inputView.inputCarNames();
        int attemptCount = inputView.inputAttemptCount();

        List<String> carNames = StringUtils.splitByComma(carNamesInput);
        List<Car> cars = createCarsFromNames(carNames);

        RacingCar racingCar = new RacingCar(cars, attemptCount);

        racingCar.startRace();
    }

    private List<Car> createCarsFromNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}