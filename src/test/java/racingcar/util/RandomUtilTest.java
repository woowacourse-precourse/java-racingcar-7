package racingcar.util;

public class RandomUtilTest implements Random {

    private final int fixedValue;

    public RandomUtilTest(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int pickNumberInRange() {
        return fixedValue;
    }
}
