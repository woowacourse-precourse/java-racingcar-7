package racingcar.model.car;

import java.util.regex.Pattern;
import racingcar.common.ErrorMessage;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateNameLength(name);
        validateNameCharacters(name);
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    private void validateNameCharacters(final String name) {
        if (!VALID_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_INVALID_CHARACTER.getMessage());
        }
    }

    public String getCarName() {
        return name;
    }
}
