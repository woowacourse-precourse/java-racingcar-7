package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.ErrorMessage;
import racingcar.util.Limit;
import racingcar.util.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarController {

    public List<String> splitCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(Regex.DELIMITER_COMMA.getRegex())).toList();
        validateCarNames(carNames);
        return carNames;
    }

    public void validateCarNames(List<String> carNames) {
        if (carNames.size() > Limit.CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.MAX_CAR_COUNT.getError());
        }
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR.getError());
        }
    }

    public Car createSingleCar(String carName) {
        return Car.createDefaultCar(carName);
    }

    public List<Car> createAllCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(createSingleCar(carName));
        }

        return cars;
    }
}
