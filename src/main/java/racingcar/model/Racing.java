package racingcar.model;

import static racingcar.util.Validator.validateRacingCarCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<RacingCar> allRacers;

    public Racing(List<String> racerNames) {
        validateRacingCarCount(racerNames);
        this.allRacers = racerNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<RacingCar> start(Integer totalTrialCount) {
        for (int trial = 1; trial <= totalTrialCount; trial++) {
            allRacers.forEach(RacingCar::moveOrStop);
        }
        return allRacers;
    }
}
