package racingcar.domain;

public class MoveConditionChecker {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final NumberGenerator numberGenerator;

    public MoveConditionChecker(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMove() {
        return numberGenerator.generate() >= MINIMUM_NUMBER_TO_MOVE;
    }
}
