package racingcar.model;

public class TryCount {
    private final int tryCount;

    public TryCount(String count) {
        this.tryCount = convertStringToInt(count);
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
