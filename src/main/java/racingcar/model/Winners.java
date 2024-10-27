package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    private Winners(Cars cars) {
        this.winners = getWinners(cars.getCars());
    }

    public static Winners from(Cars cars) {
        return new Winners(cars);
    }

    private List<Car> getWinners(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
