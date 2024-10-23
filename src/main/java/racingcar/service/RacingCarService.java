package racingcar.service;

import racingcar.domain.NumberOfAttempts;
import racingcar.domain.RacingCars;

public class RacingCarService {
    private final RacingCars racingCars;
    private final NumberOfAttempts numberOfAttempts;

    public RacingCarService(String readCarNames, String readNumberOfAttempts) {
        racingCars = new RacingCars(readCarNames);
        numberOfAttempts = new NumberOfAttempts(readNumberOfAttempts);
    }
}
