package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String text;

    public Name(String text) {
        validateNameLength(text);
        this.text = text;
    }

    private void validateNameLength(String text) {
        if (isUnderValidNameLength(text) || isOverValidNameLength(text)) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다");
        }
    }

    private boolean isUnderValidNameLength(String text) {
        return text.isEmpty();
    }

    private boolean isOverValidNameLength(String text) {
        return text.length() > MAXIMUM_NAME_LENGTH;
    }

    private String getName() {
        return text;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Name name)) {
            return false;
        }
        return Objects.equals(text, name.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text;
    }
}
