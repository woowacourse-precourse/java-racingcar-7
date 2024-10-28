package racingcar;

public class PositionSign {
    private final String sign;

    public PositionSign(int position) {
        this.sign = "-".repeat(Math.max(0, position));
    }

    @Override
    public String toString() {
        return sign;
    }
}
