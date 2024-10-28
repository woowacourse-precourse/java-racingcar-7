package racingcar;

public class GameManage {

    private final int value;
    private GameManage(final String value) {
        int convertedValue = parseint(value);
        validate(convertedValue);
        this.value = convertedValue;
    }
    public static GameManage of(String value) {
        return new GameManage(value);
    }
    public int getValue() {
        return value;
    }
    private void validate(final int convertedValue) {
        if (convertedValue < 0) {
            throw new IllegalArgumentException("시도 횟수 오류");
        }
    }
    private int parseint(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 입력");
        }
    }
}