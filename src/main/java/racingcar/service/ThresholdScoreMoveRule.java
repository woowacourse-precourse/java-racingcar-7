package racingcar.service;

public final class ThresholdScoreMoveRule implements MoveRule {
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int FORWARD = 1;
    private static final int STOP = 0;
    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;

    @Override
    public int tryMove() {
        int number = generateNumber();
        if (number >= MIN_MOVE_NUMBER) {
            return FORWARD;
        }
        return STOP;
    }

    private int generateNumber() {
        return NumberGenerator.generateNumber(MIN_NUM, MAX_NUM);
    }
    
}
