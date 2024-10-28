package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public class RacingResult {
    private final List<Car> cars;

    private final List<String> winners;

    public RacingResult(List<Car> cars, List<String> winners) {
        this.cars = cars;
        this.winners = winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return winners;
    }
}
