package racingcar.model;

public class Number {

    private final int value;

    public Number(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력하세요.");
        }
    }

    public int getValue() {
        return this.value;
    }

}
