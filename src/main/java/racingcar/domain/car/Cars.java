package racingcar.domain.car;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MIN_CAR_LENGTH = 1;
    private static final int MAX_CAR_LENGTH = 100;
    private static final String CAR_LENGTH_ERROR_MESSAGE =
            String.format("자동차의 개수는 %d 이상 %d 이하여야 합니다.", MIN_CAR_LENGTH, MAX_CAR_LENGTH);
    private static final String DUPLICATED_CAR_NAME_MESSAGE = "중복된 자동차가 존재합니다.";
    private static final String NOT_FOUND_MAX_CARS_MESSAGE = "max Car를 찾을 수 없습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCarLength(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(List<String> names, MovementStrategy movementStrategy) {
        List<CarName> carNames = CarName.listOf(names);
        validateDuplicatedName(carNames);
        List<Car> cars = createCars(carNames, movementStrategy);

        return new Cars(cars);
    }

    private void validateCarLength(List<Car> cars) {
        if (cars.size() < MIN_CAR_LENGTH || cars.size() > MAX_CAR_LENGTH) {
            throw new IllegalArgumentException(CAR_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicatedName(List<CarName> carNames) {
        Set<CarName> uniqueCarNames = new HashSet<>(carNames);
        if (carNames.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME_MESSAGE);
        }
    }

    private static List<Car> createCars(List<CarName> carNames, MovementStrategy movementStrategy) {
        return carNames.stream()
                .map(carName -> new Car(carName, movementStrategy))
                .toList();
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<CarStatus> getAllCarStatuses() {
        return cars.stream()
                .map(Car::getStatus)
                .toList();
    }

    public List<Car> getMaxCars() {
        Car maxCar = getMaxCar();
        return cars.stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .toList();
    }

    private Car getMaxCar() {
        return cars.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MAX_CARS_MESSAGE));
    }

}
