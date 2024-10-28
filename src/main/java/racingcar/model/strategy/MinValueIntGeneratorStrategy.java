package racingcar.model.strategy;

public class MinValueIntGeneratorStrategy implements IntGeneratorStrategy {
    private final static int MIN_NUMBER = 0;

    @Override
    public int getIntValue() {
        return MIN_NUMBER;
    }
}
