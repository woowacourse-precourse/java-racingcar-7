package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        return new Winners(cars.getWinners());
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
