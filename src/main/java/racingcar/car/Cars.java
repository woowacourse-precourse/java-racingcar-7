package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> names) {
        names.stream()
                .map(CarName::new)
                .map(Car::new)
                .forEach(cars::add);
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
