package racingcar.domain;

import java.util.List;

public class Winner {

    private final List<Car> winners;

    public Winner(Cars cars, Car car) {
        this.winners = cars.findWinners(car);
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
