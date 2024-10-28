package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.RacingRoundResultRecorder;

public class RacingRound {
    private final RandomNumbersGenerator randomNumbersGenerator;

    public RacingRound(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public void recordRound(Cars cars, RacingRoundResultRecorder racingRoundResultRecorder) {
        recordEachMoveResult(cars, racingRoundResultRecorder);
    }

    private void recordEachMoveResult(Cars cars, RacingRoundResultRecorder racingRoundResultRecorder) {
        racingRoundResultRecorder.record(cars.moveEach(randomNumbersGenerator.generate(cars.count())));
    }
}
