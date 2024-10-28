package racingcar.service;

import racingcar.model.Car;
import racingcar.validator.CarValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {

    private final CarValidator carValidator = new CarValidator();

    public List<Car> generateCars(String inputCarNames) {
        List<String> carNames = processCarNames(inputCarNames);
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name,0,0));
        }

        return cars;
    }

    public List<String> processCarNames(String inputCarNames) {
        carValidator.validateInputCarNames(inputCarNames);
        List<String> carNames = Arrays.asList(inputCarNames.split(","));
        carValidator.validateAllCarNames(carNames);
        return carNames;
    }
}
