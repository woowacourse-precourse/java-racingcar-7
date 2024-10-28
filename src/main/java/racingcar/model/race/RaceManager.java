package racingcar.model.race;

import java.util.List;
import racingcar.model.car.Car;

public class RaceManager {
    private final Race race;
    private final int tryCount;

    public RaceManager(List<Car> cars, int tryCount) {
        this.race = new Race(cars);
        this.tryCount = tryCount;
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            race.moveCars();
        }
    }
}
