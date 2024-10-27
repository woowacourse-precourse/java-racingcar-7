package racingcar.util;

public class TestRandomUtil implements RandomUtil {

    private static TestRandomUtil instance;

    private final int fixedResult;

    public TestRandomUtil(int fixedResult) {
        this.fixedResult = fixedResult;
    }

    @Override
    public int pickCarNumber() {
        return fixedResult;
    }
}
