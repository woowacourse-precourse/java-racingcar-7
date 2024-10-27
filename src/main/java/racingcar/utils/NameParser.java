package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class NameParser {
    private static final String COMMA_DELIMITER = ",";

    public static List<String> parse(String input) {
        String[] split = input.split(COMMA_DELIMITER);
        List<String> validNames = getNames(split);
        InputValidator.validateDuplicates(validNames);
        return validNames;
    }

    private static List<String> getNames(String[] split){
        List<String> validNames = new ArrayList<>();

        for (String name : split) {
            name = name.trim();
            InputValidator.validateName(name);
            validNames.add(name);
        }
        return validNames;
    }


}
