package racingcar.domain.race;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.domain.acceleration.Acceleration;
import racingcar.domain.car.Car;

public class Race {

    private List<Car> cars;

    private Race(final List<Car> cars) {
        this.cars = cars;
    }

    public static Race of(final String input, final Acceleration acceleration) {
        List<Car> cars = Arrays.stream(input.split(","))
            .map(name -> new Car(name.trim(), acceleration))
            .collect(Collectors.toUnmodifiableList());

        return new Race(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getResult() {
        return cars.stream()
            .map(Car::toString)
            .collect(Collectors.joining("\n"));
    }

    public void lap() {
        cars.forEach(Car::move);
    }
}
