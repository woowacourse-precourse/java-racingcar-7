package racingcar.converter;

import java.util.List;
import racingcar.exception.Validator;

public class StringToListConverter {
    private final String input;
    private static final String DELIMITER = ",";

    public StringToListConverter(String input) {
        this.input = input;
    }

    public List<String> parsingCarName() {
        Validator.isNotBLANK(input);
        List<String> inputList = List.of(input.split(DELIMITER));
        Validator.isDuplicatedCarName(inputList);
        Validator.overFiveCharsInCarName(inputList);
        return inputList;
    }
}
