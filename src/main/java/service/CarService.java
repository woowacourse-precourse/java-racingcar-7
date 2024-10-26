package service;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class CarService {

    private static final String COMMA = ",";

    public List<Car> createCarList(String carNames) {
        List<String> carNameList = parseCarNames(carNames);
        return carNameList.stream().map(Car::new).toList();
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(COMMA)).map(this::preProcess).toList();
    }

    private String preProcess(String carName) {
        return carName.trim();
    }
}
