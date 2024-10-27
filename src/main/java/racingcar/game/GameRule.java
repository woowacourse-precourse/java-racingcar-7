package racingcar.game;

import racingcar.NumberGenerator;

public class GameRule {
    private final NumberGenerator numberGenerator;
    private final int MIN_RANGE = 0;
    private final int MAX_RANGE = 9;
    private final int MOVE_LIMIT = 4;

    public GameRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMove() {
        return generateRandomNumber() <= MOVE_LIMIT;
    }

    private int generateRandomNumber() {
        return numberGenerator.random(MIN_RANGE, MAX_RANGE);
    }
}
