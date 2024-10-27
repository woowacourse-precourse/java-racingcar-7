package racingcar.util;

public class RandomUtilTest implements Random {

    public static final int FAIL_CONDITION = 3;
    public static final int SUCCESS_CONDITION = 5;

    private final int fixedValue;

    public RandomUtilTest(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int pickNumberInRange() {
        return fixedValue;
    }
}
