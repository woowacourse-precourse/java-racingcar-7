package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static final String INPUT_DELIMITER = ",";

    public List<String> parseCarName(String inputValue) {
        return Arrays.stream(inputValue.split(INPUT_DELIMITER))
                .map(String::trim)
                .toList();
    }

    public int parseGameRounds(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 횟수는 숫자만 입력가능합니다.");
        }
    }
}
