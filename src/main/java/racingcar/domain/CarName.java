package racingcar.domain;

import java.util.Objects;
import java.util.regex.Pattern;

import static racingcar.exception.ExceptionMessage.NAME_OUT_OF_RANGE;
import static racingcar.exception.ExceptionMessage.WRONG_NAME_FORMAT;

public record CarName(String name) {

    public static final int MAXIMUM = 5;
    public static final Pattern SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ]");

    public CarName {
        validateCarsName(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.isBlank() || name.length() > MAXIMUM) {
            throw new IllegalArgumentException(NAME_OUT_OF_RANGE.formatMessage(MAXIMUM));
        }
    }

    private void validateCarsName(String name) {
        if (SPECIAL_CHARACTER.matcher(name).find()) {
            throw new IllegalArgumentException(WRONG_NAME_FORMAT.getMessage());
        }
    }
}
