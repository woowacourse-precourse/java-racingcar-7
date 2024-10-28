package racingcar.controller;

import static racingcar.exception.InputErrorCode.INPUT_NAME_ERROR;
import static racingcar.exception.InputErrorCode.INPUT_TIMES_ERROR;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseNamesToList(String nameInput) {
        if (nameInput == null) {
            throw new IllegalArgumentException(INPUT_NAME_ERROR.message());
        }
        return Arrays.stream(nameInput.split(","))
                .map(String::trim)
                .toList();
    }

    public long parseTimesToLong(String timeInput) {
        try {
            String trimmedNameInput = timeInput.trim();
            return Long.parseLong(trimmedNameInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TIMES_ERROR.message());
        }
    }
}
