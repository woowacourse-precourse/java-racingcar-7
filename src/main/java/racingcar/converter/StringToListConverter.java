package racingcar.converter;

import java.util.List;
import racingcar.exception.Validator;

public class StringToListConverter {
    private final String input;

    public StringToListConverter(String input) {
        this.input = escapeSpecialRegexChars(input);
    }

    public List<String> parsingCarName() {
        Validator.isNotBLANK(input);
        List<String> inputList = List.of(input.split(","));
        Validator.isDuplicatedCarName(inputList);
        Validator.overFiveCharsInCarName(inputList);
        return inputList;
    }

    private String escapeSpecialRegexChars(String input) {
        return input.replaceAll("([\\\\.\\^\\$\\*\\+\\?\\(\\)\\[\\]\\{\\}\\|])", "\\\\$1");
    }
}
