package racingcar.controller;

import racingcar.RandomNumberGenerator;
import racingcar.model.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.validator.Validator.*;

public class RacingGameController {
    private List<Car> cars;

    public List<String> parseCarNames() {
        String input = InputView.getCarNames();
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        Validator.validateAll(carNames);
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return carNames;
    }

    public int getAttemptCount() {
        int attemptCount = InputView.getAttemptCount();
        Validator.validateAll(attemptCount);
        return attemptCount;
    }

    public void startRace() {
        raceCars();
    }

    private void raceCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

}
