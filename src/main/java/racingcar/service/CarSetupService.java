package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.util.Validator;

public class CarSetupService {

    public List<Car> setupCars(String carNamesInput) {
        List<String> carNames = parseCarNames(carNamesInput);
        validateCarNames(carNames);
        return createCarList(carNames);
    }

    private List<String> parseCarNames(String input) {
        return List.of(input.split(","));
    }

    private void validateCarNames(List<String> carNames) {
        Validator.checkCarNameLength(carNames);
        Validator.checkCarNamesUnique(carNames);
    }

    private List<Car> createCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
