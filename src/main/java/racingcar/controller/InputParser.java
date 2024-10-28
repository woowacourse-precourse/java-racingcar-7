package racingcar.controller;

import static racingcar.exception.InputErrorCode.INPUT_NAME_ERROR;
import static racingcar.exception.InputErrorCode.INPUT_TIMES_ERROR;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseNamesToList(String nameInput) {
        try {
            String[] split = nameInput.split(",");
            return Arrays.stream(split).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_NAME_ERROR.message());
        }
    }

    public long parseTimesToLong(String timeInput) {
        try {
            return Long.parseLong(timeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TIMES_ERROR.message());
        }
    }
}
