package racingcar.domain;

import static racingcar.exception.Exception.DUPLICATE_NAME;
import static racingcar.exception.Exception.NOT_ENOUGH_CARS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {

    public static final int MINIMUM_CAR_COUNT = 2;
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars of(List<String> names) {
        validate(names);
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    private static void validate(List<String> names) {
        validateDuplicateName(names);
        validateEnoughCars(names);
    }

    private static void validateEnoughCars(List<String> names) {
        if (names.size() < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(NOT_ENOUGH_CARS.getMessage());
        }
    }

    private static void validateDuplicateName(List<String> names) {
        Set<String> duplicateNames = new HashSet<>(names);

        if (duplicateNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<CarSnapshot> getSnapshots() {
        return cars.stream()
                .map(CarSnapshot::capture)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
