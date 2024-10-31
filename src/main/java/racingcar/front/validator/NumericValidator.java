package racingcar.front.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericValidator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]\\d*$");

    public static boolean isNaturalNumber(String input) {
        Matcher matcher = NUMBER_REGEX.matcher(input);
        return matcher.matches();
    }
}
