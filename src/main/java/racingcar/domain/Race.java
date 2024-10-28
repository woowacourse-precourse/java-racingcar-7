package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Race {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Race(List<String> carNames, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;

        validateDuplicates(carNames);
        this.cars = createCars(carNames);
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

    private void validateDuplicates(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : carNames) {
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("중복된 차 이름이 있습니다.");
            }
        }
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, numberGenerator))
                .toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
