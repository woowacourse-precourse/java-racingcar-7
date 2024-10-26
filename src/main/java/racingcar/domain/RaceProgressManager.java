package racingcar.domain;

import racingcar.dto.RaceResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceProgressManager {
    private final Map<String, Integer> raceProgress = new HashMap<>();

    public RaceProgressManager(List<RacingCar> cars) {
        cars.forEach(car -> raceProgress.put(car.getName(), 0));
    }

    public void updateProgressForForward(RacingCar car) {
        raceProgress.put(car.getName(), raceProgress.get(car.getName()) + 1);
    }

    public RaceResult createRaceResult() {
        return new RaceResult(new HashMap<>(raceProgress));
    }
}
