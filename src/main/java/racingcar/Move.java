package racingcar;

import static racingcar.RacingConstants.MIN_NUMBER_TO_MOVE;

public class Move {
    private final NumberGenerator numberGenerator;

    public Move(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean can() {
        int number = numberGenerator.pickOne();
        return isPossible(number);
    }

    private boolean isPossible(int number) {
        return number >= MIN_NUMBER_TO_MOVE;
    }
}
