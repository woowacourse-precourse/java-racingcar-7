package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<String> parseCarNamesByOperator(String inputStr, String operator) {
        return Arrays.stream(inputStr.split(operator)).toList();
    }

    public long parseRepeatCount(String inputStr) {
        return Long.parseLong(inputStr);
    }
}
