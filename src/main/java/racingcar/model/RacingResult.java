package racingcar.model;

import java.util.List;

public class RacingResult {

    private final List<RacingCar> racingResult;
    private final int totalTrialCount;
    private final int maxDistance;

    public RacingResult(List<RacingCar> racingResult, Integer totalTrialCount) {
        this.racingResult = racingResult;
        this.totalTrialCount = totalTrialCount;
        this.maxDistance = findMaxDistance();
    }

    public Integer findMaxDistance() {
        return racingResult.stream()
                .map(racingCar -> racingCar.getDistance(totalTrialCount))
                .reduce(maxDistance, Integer::max);
    }

    public List<String> findWinner() {
        return racingResult.stream()
                .filter(racingCar -> racingCar.getDistance(totalTrialCount) == maxDistance)
                .map(RacingCar::getName)
                .toList();
    }

    public List<RacingCar> get() {
        return racingResult;
    }
}
