package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(Cars cars) {
        this.winners = cars.findWinners();
    }

    public String getWinnersNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
