package racingcar.io;

import java.util.List;

public class InputParser {

    private static final String INVALID_NUMBER_ERROR = "유효한 숫자를 입력해 주세요.";

    public List<String> parseCarNames(String input) {
        return List.of(input.split(","));
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
    }

}

