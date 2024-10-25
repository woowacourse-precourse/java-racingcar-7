package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private final List<Car> winners;
    private final List<RacingSnapshot> snapshots;

    public RacingResult(RacingCars cars, List<RacingSnapshot> snapshots) {
        this.winners = cars.findWinners();
        this.snapshots = snapshots;
    }

    public List<String> getWinner() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<RacingSnapshot> getSnapshots() {
        return snapshots;
    }
}
