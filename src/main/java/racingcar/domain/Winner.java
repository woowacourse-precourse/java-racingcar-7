package racingcar.domain;

import java.util.List;

public class Winner {

    private final List<Car> winners;

    public Winner(Cars cars, Car car) {
        this.winners = cars.findWinners(car);
    }

    public String winnerInfo() {
        return winners.getFirst().joinCars(winners);
    }
}
