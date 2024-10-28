package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Race {

    private static final String ERROR_DUPLICATED_CAR_NAME = "중복된 이름의 자동차가 존재합니다.";
    public static final String ERROR_AT_LEAST_TWO_CARS = "둘 이상의 자동차가 경주에 참여해야 합니다.";
    private final List<Car> cars;

    public Race(List<Car> cars) {
        validateDuplicates(cars);
        validateAtLeastTwoCars(cars);
        this.cars = cars;
    }

    public List<Car> moveAll() {
        cars.forEach(Car::move);
        return cars;
    }

    public List<Car> findWinners() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private void validateDuplicates(List<Car> cars) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (Car car : cars) {
            String carName = car.getName();
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException(ERROR_DUPLICATED_CAR_NAME);
            }
        }
    }

    private void validateAtLeastTwoCars(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(ERROR_AT_LEAST_TWO_CARS);
        }
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
