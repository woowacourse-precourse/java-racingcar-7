package racingcar.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    private final String carNames;
    private static final String COMMA = ",";

    public Splitter(String carNames) {
        this.carNames = carNames;
    }

    public List<Car> splitSeparator() {
        List<String> splitCarNames = Arrays.stream(carNames.split(COMMA)).toList();
        List<String> trimCarNames = trimCarNames(splitCarNames);
        List<String> carNames = removeEmpty(trimCarNames);
        return createCarList(carNames);
    }

    public List<String> trimCarNames(List<String> splitCarNames) {
        return new ArrayList<>(splitCarNames.stream()
                .map(String::trim)
                .toList());
    }

    public List<String> removeEmpty(List<String> trimCarNames) {
        trimCarNames.removeIf(String::isBlank);
        return trimCarNames;
    }

    public List<Car> createCarList(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
