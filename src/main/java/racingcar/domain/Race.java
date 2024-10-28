package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Race {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Race(String rawCarNames, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        List<String> parsedCarNames = parseCarNames(rawCarNames);
        validateDuplicates(parsedCarNames);
        this.cars = createCars(parsedCarNames);
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

    private List<String> parseCarNames(String rawCarNames) {
        return Stream.of(rawCarNames.split(","))
                .toList();
    }

    private void validateDuplicates(List<String> parsedCarNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : parsedCarNames) {
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("중복된 차 이름이 있습니다.");
            }
        }
    }

    private List<Car> createCars(List<String> parsedCarNames) {
        return parsedCarNames.stream()
                .map(parsedCarName -> new Car(parsedCarName, numberGenerator))
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
