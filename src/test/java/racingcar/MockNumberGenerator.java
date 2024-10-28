package racingcar;

public class MockNumberGenerator extends NumberGenerator {
    private int value;

    public void setGeneratedNumber(int value) {
        this.value = value;
    }

    @Override
    public int random(int min, int max) {
        return value;
    }
}
