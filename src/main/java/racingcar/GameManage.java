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
}