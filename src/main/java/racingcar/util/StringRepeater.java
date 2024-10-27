package racingcar.util;

public class StringRepeater {

    private final String value;

    public StringRepeater(final String value) {
        this.value = value;
    }

    public String repeat(long count) {
        if (count < 0) {
            throw new IllegalArgumentException("count는 음수일 수 없습니다.");
        }
        if (count == 1) {
            return value;
        }

        StringBuilder repeatedValue = new StringBuilder();
        for (long i = 0; i < count; i++) {
            repeatedValue.append(value);
        }
        return repeatedValue.toString();
    }
}
