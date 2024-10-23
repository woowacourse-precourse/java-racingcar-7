package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<RacingCar> racingCars;
    private final int trialCount;

    public Racing(List<String> carRacers, int trialCount) {
        this.racingCars = setCarRacers(carRacers);
        this.trialCount = trialCount;
    }
    private ArrayList<RacingCar> setCarRacers(List<String> carRacers) {
        return carRacers.stream()
                .map(RacingCar::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<RacingCar> startRace() {
        for (int i = 1; i <= trialCount; i++) {
            racingCars.forEach(RacingCar::moveOrStop);
        }
        return racingCars;
    }

    public int findMaxMoves() {
        return racingCars.stream()
                .map(racingCar -> racingCar.getCurrentMoveCount(trialCount))
                .reduce(0, Integer::max);
    }

    public List<String> findWinners(int maxMoves) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getCurrentMoveCount(trialCount) == maxMoves)
                .map(RacingCar::getName)
                .toList();
    }
}
