package racingcar.domain.result;

import java.util.List;
import racingcar.domain.car.Car;

public class RaceResult {
    private final List<Car> winners;

    public RaceResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }
}