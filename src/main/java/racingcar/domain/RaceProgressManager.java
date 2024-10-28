package racingcar.domain;

import static racingcar.exception.ErrorMessage.*;

import racingcar.dto.RaceResult;
import racingcar.exception.RacingCarException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RaceProgressManager {
    private final Map<String, Integer> raceProgress = new HashMap<>();

    public RaceProgressManager(List<RacingCar> cars) {
        validateUniqueNames(cars);
        cars.forEach(car -> raceProgress.put(car.getName(), 0));
    }

    public void updateProgressForForward(RacingCar car) {
        validateCarIsRegistered(car);
        raceProgress.put(car.getName(), raceProgress.get(car.getName()) + 1);
    }

    public RaceResult createRaceResult() {
        return new RaceResult(new HashMap<>(raceProgress));
    }

    private void validateUniqueNames(List<RacingCar> cars) {
        Set<String> uniqueNames = new HashSet<>();
        cars.forEach(car -> addUniqueName(car, uniqueNames));
    }

    private void addUniqueName(RacingCar car, Set<String> uniqueNames) {
        if (!uniqueNames.add(car.getName())) {
            throw RacingCarException.from(UNIQUE_CAR_NAME_REQUIRED);
        }
    }

    private void validateCarIsRegistered(RacingCar car) {
        if (!raceProgress.containsKey(car.getName())) {
            throw RacingCarException.from(CAR_MUST_BE_REGISTERED);
        }
    }
}
