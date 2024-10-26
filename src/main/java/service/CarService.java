package service;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarValidator;

public class CarService {

    private static final String COMMA = ",";

    public List<Car> createCarList(String carNames) {
        List<String> carNameList = parseCarNames(carNames);
        List<Car> carList = carNameList.stream().map(Car::new).toList();

        CarValidator.validate(carList);

        return carList;
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(COMMA)).map(this::preProcess).toList();
    }

    private String preProcess(String carName) {
        return carName.trim();
    }
}
