package mock;

import racingcar.model.RandomNumberGenerator;

public class ManualMockRandomNumberGenerator implements RandomNumberGenerator {

    private final int[] values;
    private int index = 0;

    public ManualMockRandomNumberGenerator(int... values) {
        this.values = values;
    }

    @Override
    public int pickNumberInRange(int min, int max) {
        int value = values[index];
        index = (index + 1) % values.length;
        return value;
    }
}
