package racingcar.model;

import java.util.List;
import racingcar.view.ErrorMessage;

public class RaceCars {
    private static final int DEFAULT_POSITION = 0;
    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private final List<Car> cars;

    public RaceCars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public void moveAllCars(Movement movement) {
        cars.forEach(car -> car.move(movement.isAbleToMove()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaximumPosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition().getValue())
                .max()
                .orElse(DEFAULT_POSITION);
    }

    public List<String> getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().getValue() == maxPosition)
                .map(car -> car.getName().getValue())
                .toList();
    }

    private void validate(List<Car> cars) {
        validateDuplicatedCars(cars);
        validateNumberOfCars(cars);
    }

    private void validateDuplicatedCars(List<Car> cars) {
        long distinctCarNumber = cars.stream().distinct().count();
        if (distinctCarNumber != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_RACINGCAR.getMessage());
        }
    }

    private void validateNumberOfCars(List<Car> cars) {
        if (hasInappropriateNumberOfCars(cars)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACINGCAR_NUMBER.getMessage());
        }
    }

    private boolean hasInappropriateNumberOfCars(List<Car> cars) {
        return cars.size() < MINIMUM_NUMBER_OF_CARS;
    }
}
