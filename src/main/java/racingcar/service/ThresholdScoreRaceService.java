package racingcar.service;

import racingcar.domain.Racing;
import racingcar.util.NumberGenerator;

public final class ThresholdScoreRaceService implements RaceService {
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int FORWARD = 1;
    private static final int STOP = 0;
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private final NumberGenerator numberGenerator;

    public ThresholdScoreRaceService(final NumberGenerator randomNumberGenerator) {
        this.numberGenerator = randomNumberGenerator;
    }

    @Override
    public void performRace(Racing racing) {
        racing.getCars().forEach(car -> car.move(determineMove()));
    }

    public int determineMove() {
        int number = generateNumber();
        if (number >= MIN_MOVE_NUMBER) {
            return FORWARD;
        }
        return STOP;
    }

    private int generateNumber() {
        return numberGenerator.generateNumber(MIN_NUM, MAX_NUM);
    }

}
