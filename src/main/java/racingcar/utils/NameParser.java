package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class NameParser {
    private static final String COMMA_DELIMITER = ",";

    public static List<String> parse(String input) {
        String[] splitedInput = input.split(COMMA_DELIMITER);
        List<String> validNames = getNames(splitedInput);
        InputValidator.validateDuplicates(validNames);
        return validNames;
    }

    private static List<String> getNames(String[] splitedInput){
        List<String> validNames = new ArrayList<>();

        for (String name : splitedInput) {
            name = name.trim();
            InputValidator.validateName(name);
            validNames.add(name);
        }
        return validNames;
    }


}
