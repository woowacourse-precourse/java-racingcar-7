package racingcar.domain;

import static racingcar.util.StringParser.NAME_DELIMITER;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public final class RacingCars {

    private final LinkedHashSet<Car> cars;

    private RacingCars(LinkedHashSet<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars of(final Collection<Car> cars) {
        return new RacingCars(new LinkedHashSet<>(cars));
    }

    public static RacingCars from(final Collection<String> names) {
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (String name : names) {
            cars.add(Car.of(name));
        }

        return new RacingCars(cars);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    @Override
    public String toString() {
        List<String> names = cars.stream()
                .map(Car::getName)
                .toList();

        return String.join(NAME_DELIMITER + " ", names);
    }
}
