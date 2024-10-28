package racingcar.race.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racer {
    private final List<Car> cars;

    private Racer(List<Car> cars) {
        this.cars = cars;
    }

    public static Racer of(List<String> names) {
        return new Racer(names.stream().map(Car::new).toList());
    }

    public String getWinners() {
        int winnerLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("winner is null"));

        return cars.stream().filter(car -> car.isSameLocation(winnerLocation))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public String getExecutedRound(int round) {
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
