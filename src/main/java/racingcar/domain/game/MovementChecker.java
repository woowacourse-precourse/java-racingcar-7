package racingcar.domain.game;

import racingcar.domain.utils.RandomNumberGenerator;

public class MovementChecker {
    private static final int THRESHOLD = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public boolean isMovable() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= THRESHOLD;
    }

    private static int generateRandomNumber() {
        return RandomNumberGenerator.randomNumberGenerator(MIN_NUMBER, MAX_NUMBER);
    }
}
