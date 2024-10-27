package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.utils.Validator;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void registerCars(String carNames) {
        List<String> names = splitNames(carNames);
        addCars(names);
    }

    private List<String> splitNames(String carNames) {
        String cleanedNames = trimSpaces(carNames);
        return Stream.of(cleanedNames.split(","))
                .collect(Collectors.toList());
    }

    private String trimSpaces(String carNames) {
        return carNames.replaceAll("\\s+", "");
    }

    private void addCars(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void validateNameLength(String name) {
        Validator.checkNameLength(name);
    }

    public List<Car> getCars() {
        return cars;
    }
}
