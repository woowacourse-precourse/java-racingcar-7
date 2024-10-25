package racingcar.model;

import java.util.List;

public class RacingResult {

    private final List<RacingCar> racingRecords;
    private int maxDistance;

    public RacingResult(List<RacingCar> racingRecords) {
        this.racingRecords = racingRecords;
    }

    public Integer findMaxDistance(Integer totalTrialCount) {
        return racingRecords.stream()
                .map(racingCar -> racingCar.getDistance(totalTrialCount))
                .reduce(maxDistance, Integer::max);
    }

    public List<String> findWinner(Integer totalTrialCount) {
        this.maxDistance = findMaxDistance(totalTrialCount);
        return racingRecords.stream()
                .filter(racingCar -> racingCar.getDistance(totalTrialCount) == maxDistance)
                .map(RacingCar::getName)
                .toList();
    }

    public List<RacingCar> get() {
        return racingRecords;
    }
}
