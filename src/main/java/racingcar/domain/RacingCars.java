package racingcar.domain;

import java.util.List;

public class RacingCars {

    List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public long findMaxMoveCount() {
        return racingCars.stream()
                .mapToLong(RacingCar::getMoveCount)
                .max()
                .orElseThrow();
    }

    public RacingCars findBestDriver(long maxMoveCount) {
        List<RacingCar> bestDrivers = racingCars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .toList();
        return new RacingCars(bestDrivers);
    }

    public void runRound() {
        racingCars.forEach(RacingCar::move);
    }

    public int size() {
        return racingCars.size();
    }

    public List<RacingCar> getRacingCars() {
        return List.copyOf(racingCars);
    }

}
