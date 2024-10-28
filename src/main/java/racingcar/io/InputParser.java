package racingcar.io;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String INVALID_NUMBER_ERROR = "유효한 숫자를 입력해주세요.";

    public List<String> parseCarNames(String input) {
        List<String> carNames = new ArrayList<>(List.of(input.split(",")));

        carNames.replaceAll(String::trim);

        return carNames;
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
    }

}

