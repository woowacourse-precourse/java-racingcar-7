package racingcar.utils;

public class MoveDecider {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final NumberGenerator numberGenerator;

    public MoveDecider(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMovable() {
        return getRandomNumber() >= MOVE_THRESHOLD;
    }

    private int getRandomNumber() {
        return numberGenerator.generate(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
