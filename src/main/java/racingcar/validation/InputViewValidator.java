package racingcar.validation;

import java.util.regex.Pattern;
import racingcar.common.ExceptionCode;

public class InputViewValidator {
    private static final String REGEX_INVALID_DELIMITER_PATTERN = ".*[^,\\w\\s].*";
    private static final Pattern InvalidDelimiter = Pattern.compile(REGEX_INVALID_DELIMITER_PATTERN);

    public void validateDelimiter(String input) {
        if (InvalidDelimiter.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_DELIMITER.getMessage());
        }
    }

    public void validateMoveCount(String input) {
        if (input.isBlank() || !isNumber(input)) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_MOVE_COUNT.getMessage());
        }
    }

    public boolean isNumber(String string) {
        for(char c : string.toCharArray()){
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
