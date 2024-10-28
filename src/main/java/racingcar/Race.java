package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Race {
    private final List<Car> cars;
    private final int tryCount;

    public Race(List<String> cars, int tryCount) {
        ExceptionHandler.validateTryCount(tryCount);

        this.cars = createCars(cars);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(List<String> carsName) {
        Set<String> uniqueCarsName = new HashSet<>(carsName);

        ExceptionHandler.validateDuplicateCarName(carsName.size(), uniqueCarsName.size());

        return carsName.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
