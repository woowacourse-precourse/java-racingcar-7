package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String OPERATOR = ",";

    public List<String> parseCarNamesByOperator(String inputStr) {
        return Arrays.stream(inputStr.split(OPERATOR)).toList();
    }

    public long parseRepeatCount(String inputStr) {
        return Long.parseLong(inputStr);
    }
}
