package racingcar.domain.race;

import java.util.List;
import racingcar.domain.car.Car;

public class RoundResult {
    private final List<CarSnapshot> carSnapshots;

    public RoundResult(List<CarSnapshot> carSnapshots) {
        this.carSnapshots = carSnapshots;
    }

    public List<CarSnapshot> getCarSnapshots() {
        return carSnapshots;
    }
}
