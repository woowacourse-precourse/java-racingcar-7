package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> names) {
        final List<CarName> carNames = names.stream()
                .map(CarName::new)
                .toList();
        validateDuplicatedCar(carNames);

        carNames.stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    private void validateDuplicatedCar(final List<CarName> names) {
        final long pureCount = names.stream()
                .map(CarName::getContent)
                .map(String::toLowerCase)
                .distinct()
                .count();
        if (names.size() != (int) pureCount) {
            throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
        }
    }

    public void goOrStop(InputGenerator generator) {
        for (Car car : cars) {
            final int randomValue = generator.generate();
            if (randomValue >= 4) {
                car.forward();
            }
        }
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        final int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }
}
