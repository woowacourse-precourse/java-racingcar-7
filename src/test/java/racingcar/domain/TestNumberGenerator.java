package racingcar.domain;

public class TestNumberGenerator implements NumberGenerator {
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
