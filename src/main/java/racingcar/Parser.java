package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {

    List<String> parseCarNamesByOperator(String inputStr, String operator) {
        List<String> carNames = Arrays.stream(inputStr.split(operator)).toList();

        return carNames;
    }

    long parseRepeatCount(String inputStr) {
        return Long.parseLong(inputStr);
    }
}
