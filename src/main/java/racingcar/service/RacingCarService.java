package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.util.RandomGenerator;

import java.util.List;

public class RacingCarService {

    public RacingCars setupRaceCars(List<String> racingCarNames, RandomGenerator randomGenerator) {
        return new RacingCars(racingCarNames.stream().map((String name) -> new RacingCar(name, randomGenerator)).toList());
    }

    public void runRound(RacingCars racingCars) {
        racingCars.runRound();
    }

    public RacingCars findBestDriver(RacingCars racingCars) {
        long maxMoveCount = racingCars.findMaxMoveCount();
        return racingCars.findBestDriver(maxMoveCount);
    }
}
