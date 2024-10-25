package racingcar.model;

import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_LETTER;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_SPACE;

public class CarName {
    private static final Integer MAX_NAME_LENGTH = 5;
    private static final String LETTER_REGEX = "[a-zA-Z]+";
    final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateCarNameLength(name);
        validateEmpty(name);
        validateOnlyLetters(name);
    }

    private void validateCarNameLength(String name) {
        if (IsNotValidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    private boolean IsNotValidNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private void validateEmpty(String name) {
        if (isEmptyName(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_SPACE);
        }
    }

    private boolean isEmptyName(String name) {
        return name.isBlank();
    }

    private void validateOnlyLetters(String name) {
        if (isValidOnlyLetters(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LETTER);
        }
    }

    private boolean isValidOnlyLetters(String name) {
        return !name.matches(LETTER_REGEX);
    }

    public String getName() {
        return name;
    }
}
