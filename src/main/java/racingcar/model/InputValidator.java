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

    private final String regex = "^[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9\\s,]+$";

    public boolean isValidNames(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT_EXCEPTION_MESSAGE.getMessage());
        }

        List<String> names = List.of(input.split(","));

        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION_MESSAGE.getMessage());
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH_OVER_EXCEPTION_MESSAGE.getMessage());
            }

            if (name.startsWith(" ") | name.endsWith(" ")) {
                throw new IllegalArgumentException(START_OR_END_WITH_WHITESPACE_EXCEPTION_MESSAGE.getMessage());
            }

            if (!Pattern.matches(regex, name)) {
                throw new IllegalArgumentException(INVALID_CHARACTER_EXCEPTION_MESSAGE.getMessage());
            }
        }

        HashSet<String> forDuplicationTest = new HashSet<>(names);
        if (forDuplicationTest.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATION_NAME_EXCEPTION_MESSAGE.getMessage());
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("a" + List.of(String.valueOf("").split(",")).size() + "a");
    }
}
