package racingcar.model;

import static racingcar.message.ExceptionMessage.DUPLICATION_NAME_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.EMPTY_NAME_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.INVALID_CHARACTER_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.NAME_LENGTH_OVER_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.NULL_INPUT_EXCEPTION_MESSAGE;
import static racingcar.message.ExceptionMessage.START_OR_END_WITH_WHITESPACE_EXCEPTION_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    public boolean isValidNames(String input) {
        nullCheck(input);

        List<String> names = List.of(input.split(","));

        for (String name : names) {
            checkEmptyOf(name);
            checkThresholdLengthOf(name);
            checkStartEndWhiteSpaceOf(name);
            checkInvalidCharacterOf(name);
        }
        checkDuplicationOf(names);

        return true;
    }

    private void checkEmptyOf(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void checkThresholdLengthOf(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void checkStartEndWhiteSpaceOf(String name) {
        if (name.startsWith(" ") | name.endsWith(" ")) {
            throw new IllegalArgumentException(START_OR_END_WITH_WHITESPACE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void checkInvalidCharacterOf(String name) {
        String regex = "^[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9\\s,]+$";
        if (!Pattern.matches(regex, name)) {
            throw new IllegalArgumentException(INVALID_CHARACTER_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void checkDuplicationOf(List<String> names) {
        HashSet<String> forDuplicationTest = new HashSet<>(names);
        if (forDuplicationTest.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATION_NAME_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void nullCheck(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT_EXCEPTION_MESSAGE.getMessage());
        }
    }
}
