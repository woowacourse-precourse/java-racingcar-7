package racingcar.domain.car;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

    private static final Pattern NAME = Pattern.compile("[\\wㄱ-ㅎ가-힣_]+");
    private static final int MAX_LENGTH = 5;

    private final String value;

    private Name(final String value) {
        validate(Objects.requireNonNull(value));
        this.value = value;
    }

    public static Name from(final String value) {
        return new Name(value);
    }

    private void validate(final String value) {
        validateLength(value);
        validateNamePattern(value);
    }

    private void validateLength(final String value) {
        if (value.isEmpty() || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 1~5자로 입력해주세요.");
        }
    }

    private void validateNamePattern(final String value) {
        if (!NAME.matcher(value)
                .matches()
        ) {
            throw new IllegalArgumentException("이름은 영문(대소문자), 한글, 숫자, 언더바(_)만 입력해주세요.");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name name)) {
            return false;
        }
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
