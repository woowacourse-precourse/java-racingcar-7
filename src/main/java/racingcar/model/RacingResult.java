package racingcar.model;

import java.util.List;

public class RacingResult {

    private final List<RacingCar> racingRecords;
    private final Integer maxDistance;

    public RacingResult(List<RacingCar> racingRecords) {
        this.racingRecords = racingRecords;
        this.maxDistance = findMaxDistance();
    }

    public Integer findMaxDistance() {
        return racingRecords.stream()
                .map(RacingCar::getDistance)
                .reduce(0, Integer::max);
    }

    public List<String> findWinner() {
        return racingRecords.stream()
                .filter(racingCar -> racingCar.getDistance() == maxDistance.intValue())
                .map(RacingCar::getName)
                .toList();
    }

    public List<RacingCar> getRecord() {
        return racingRecords;
    }
}
