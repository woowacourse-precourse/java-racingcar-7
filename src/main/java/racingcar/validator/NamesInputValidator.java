package racingcar.validator;

import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

import java.util.Arrays;
import java.util.List;

public class NamesInputValidator {

    public static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new CustomException(ExceptionCode.INPUT_BLANK);
        }
        String[] tokens = input.split(",");
        List<String> names = Arrays.stream(tokens).map(String::strip).distinct().toList();
        if (names.size() <= 1) {
            throw new CustomException(ExceptionCode.CAR_SHORTAGE);
        }
        if (tokens.length != names.size()) {
            throw new CustomException(ExceptionCode.NAME_DUPLICATED);
        }
        for (String name: names) {
            if (name.length() > 5) {
                throw new CustomException(ExceptionCode.NAME_TOO_LONG);
            }
        }
    }
}
