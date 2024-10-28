package racingcar.model.strategy;

public class MaxValueIntGeneratorStrategy implements IntGeneratorStrategy {
    private final static int MAX_NUMBER = 9;

    @Override
    public int getIntValue() {
        return MAX_NUMBER;
    }
}
