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
        validateNameIsDuplicate(names);
        validateNames(names);
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
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void validateNameIsDuplicate(List<String> names) {
        Validator.validateNameIsDuplicate(names);
    }

    private void validateNames(List<String> names) {
        for (String name : names) {
            validateInputName(name);
            validateNameLength(name);
        }
    }

    private void validateInputName(String name) {
        Validator.validateNameIsEmpty(name);
    }

    private void validateNameLength(String name) {
        Validator.validateNameLengthLimit(name);
    }

    public List<Car> getCars() {
        return cars;
    }
}
