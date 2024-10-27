package racingcar.domain;

import java.util.Objects;
import racingcar.constants.Constants;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String text;

    public Name(String text) {
        validateNameLength(text);
        this.text = text;
    }

    private void validateNameLength(String text) {
        if (isEmpty(text) || isOverValidLength(text)) {
            throw new IllegalArgumentException(Constants.INVALID_NAME_LENGTH);
        }
    }

    private boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private boolean isOverValidLength(String text) {
        return text.length() > MAX_NAME_LENGTH;
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
