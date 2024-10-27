package racingcar.converter;

import java.util.List;
import racingcar.exception.Validator;

public class StringToListConverter {
    private final String input;

    public StringToListConverter(String input) {
        this.input = input;
    }

    public List<String> parsingCarName() {
        Validator.isNotBLANK(input);
        List<String> inputList = List.of(input.split(","));
        Validator.isDuplicatedCarName(inputList);
        Validator.overFiveCharsInCarName(inputList);
        return inputList;
    }
}
