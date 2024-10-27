package racingcar.race.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        return new Cars(names.stream().map(Car::new).toList());
    }

    public String getExecuteResult(int round) {
        return Stream.generate(() -> {
                    moveAll();
                    return visualize();
                })
                .limit(round)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private void moveAll() {
        this.cars.forEach(Car::move);
    }

    private String visualize() {
        return cars.stream()
                .map(Car::getProgress)
                .collect(Collectors.joining());
    }
}
