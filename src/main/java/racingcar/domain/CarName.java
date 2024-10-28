package racingcar.domain;

import java.util.regex.Pattern;

import static racingcar.exception.ExceptionMessage.*;

public record CarName(String name) {

    public static final int MINIMUM = 1;
    public static final int MAXIMUM = 5;
    public static final Pattern SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ]");

    public CarName {
        validateFormat(name);
        validateLength(name);
    }

    private void validateFormat(String name) {
        if (SPECIAL_CHARACTER.matcher(name).find()) {
            throw new IllegalArgumentException(WRONG_NAME_FORMAT.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK.formatMessage(MINIMUM));
        }
        if (name.length() > MAXIMUM) {
            throw new IllegalArgumentException(NAME_OUT_OF_RANGE.formatMessage(MAXIMUM));
        }
    }
}
