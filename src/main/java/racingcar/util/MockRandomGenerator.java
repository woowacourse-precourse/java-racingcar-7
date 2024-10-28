package racingcar.util;

public class MockRandomGenerator implements RandomGenerator {

    int returnValue;

    public MockRandomGenerator(int returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public int pickNumberInRange(int min, int max) {
        return returnValue;
    }
}
