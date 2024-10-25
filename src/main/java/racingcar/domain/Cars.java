package racingcar.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MIN_CAR_LENGTH = 1;
    private static final int MAX_CAR_LENGTH = 100;
    private static final String CAR_LENGTH_ERROR_MESSAGE =
            String.format("자동차의 개수는 %d 이상 %d 이하여야 합니다.", MIN_CAR_LENGTH, MAX_CAR_LENGTH);

    private final List<Car> cars;

    private Cars(List<CarName> carNames) {
        validateCarLength(carNames);
        this.cars = carNames.stream().map(Car::new).toList();
    }

    public static Cars from(List<String> names) {
        List<CarName> carNames = names.stream().map(CarName::new).toList();
        validateDuplicatedName(names, carNames);

        return new Cars(carNames);
    }

    private void validateCarLength(List<CarName> carNames) {
        if (carNames.size() < MIN_CAR_LENGTH || carNames.size() > MAX_CAR_LENGTH) {
            throw new IllegalArgumentException(CAR_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicatedName(List<String> names, List<CarName> carNames) {
        Set<CarName> uniqueCarNames = new HashSet<>(carNames);
        if (names.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
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
                .orElseThrow(() -> new IllegalArgumentException("max Car를 찾을 수 없습니다."));
    }

}
