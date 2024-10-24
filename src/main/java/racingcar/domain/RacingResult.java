package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private final List<Car> winners;
    private final List<String> snapshot;

    public RacingResult(RacingCars cars, List<String> snapshot) {
        this.winners = cars.findWinners();
        this.snapshot = snapshot;
    }

    public List<String> getWinner() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getSnapshot() {
        return snapshot;
    }
}
