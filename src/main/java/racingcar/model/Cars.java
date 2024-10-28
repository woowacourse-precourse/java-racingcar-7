package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import racingcar.exception.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    private static final String NAME_DELIMITER = ","; // 이름 구분자
    private static final int MIN_CAR_COUNT = 2; // 최소 자동차 수

    public Cars(String carNames) {
        this.cars = new ArrayList<>();
        addCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void addCars(String carNames) {
        checkForEmptyCarNames(carNames);
        List<String> namesList = splitCarNames(carNames);
        validateCarList(namesList);
        for (String name : namesList) {
            addCar(name);
        }
    }

    private void addCar(String name) {
        Car car = new Car(name);
        cars.add(car);
    }

    private List<String> splitCarNames(String carNames) {
        List<String> nameList = new ArrayList<>();
        Collections.addAll(nameList, carNames.split(NAME_DELIMITER));
        return nameList;
    }

    private void validateCarList(List<String> carNames) {
        checkMinimumCarCount(carNames);
        checkForDuplicateCarNames(carNames);
    }

    private void checkForEmptyCarNames(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

    private void checkMinimumCarCount(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_CARS.getMessage());
        }
    }

    private void checkForDuplicateCarNames(List<String> carNames) {
        HashSet<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            validateUniqueCarName(name, nameSet);
        }
    }

    private void validateUniqueCarName(String name, HashSet<String> nameSet) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
        }
    }
}