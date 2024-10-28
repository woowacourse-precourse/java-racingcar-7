package racingcar.domain;

import java.util.List;

public class Winners {

    private static final String WINNER_DELIMITER = ", ";

    private final List<Car> winners;

    public Winners(Cars cars, Car furthestCar) {
        this.winners = cars.findWinners(furthestCar);
    }

    @Override
    public String toString() {
        List<String> winnerList = getWinnerNames();
        return String.join(WINNER_DELIMITER, winnerList);
    }

    private List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .toList();
    }
}
