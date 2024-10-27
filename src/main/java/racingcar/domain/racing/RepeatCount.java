package racingcar.domain.racing;

public class RepeatCount {

    private final int value;

    public RepeatCount(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        if (value == null || value.isEmpty() || !value.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("자연수만 입력할 수 있습니다.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("입력 값이 10만 미만이어야합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
