package racingcar.parser;

import racingcar.constant.AppConstants;
import racingcar.constant.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMERIC.getMessage());
        }
    }

    public List<String> convertToCarNamesList(String input) {
        return Arrays.stream(input.split(AppConstants.DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}