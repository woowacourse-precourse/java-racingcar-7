package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.util.RandomGenerator;

import java.util.List;

public class RacingCarService {

    public List<RacingCar> setupRaceCars(List<String> racingCarNames, RandomGenerator randomGenerator) {
        return racingCarNames.stream().map((String name) -> new RacingCar(name, randomGenerator)).toList();
    }

    public void runRound(List<RacingCar> racingCars) {
        racingCars.forEach(RacingCar::move);
    }

    public List<RacingCar> findBestDriver(List<RacingCar> racingCars) {
        long maxMoveCount = racingCars.stream()
                .mapToLong(RacingCar::getMoveCount)
                .max()
                .orElseThrow();

        return racingCars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .toList();
    }
}
