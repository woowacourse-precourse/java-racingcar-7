package racingcar;

import static racingcar.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.ExceptionMessage.INVALID_SIZE_CAR_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    static final int MIN_CAR_SIZE = 1;
    static final int MAX_CAR_SIZE = 10;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateSize(names);
        validateDuplication(names);

        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName).toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max().orElse(0);
    }

    private void validateSize(List<String> names) {
        if (names.size() < MIN_CAR_SIZE || names.size() > MAX_CAR_SIZE) {
            throw new IllegalArgumentException(
                    String.format(INVALID_SIZE_CAR_NAME.getMessage(), MIN_CAR_SIZE, MAX_CAR_SIZE, names.size()));
        }
    }

    private void validateDuplication(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }
}