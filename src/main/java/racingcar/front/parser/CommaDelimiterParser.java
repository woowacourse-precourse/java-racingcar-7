package racingcar.front.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.front.exception.DuplicatedCarNamesException;
import racingcar.front.exception.InvalidCarNameInputException;

public class CommaDelimiterParser {
    private static final Pattern INPUT_FORMAT = Pattern.compile("^[^,\\s]{1,5}(?:,[^,\\s]{1,5})*$");
    private static final String COMMA = ",";

    public static List<String> parse(String carNames) {
        if (isMatch(carNames) == false) {
            throw new InvalidCarNameInputException();
        }

        String[] splitCarNames = carNames.split(COMMA);

        if (checkDuplicatedNames(splitCarNames)) {
            throw new DuplicatedCarNamesException();
        }

        return Arrays.stream(splitCarNames).toList();
    }

    private static boolean isMatch(String carNames) {
        return INPUT_FORMAT.matcher(carNames).matches();
    }

    private static boolean checkDuplicatedNames(String[] carNames){
        Set<String> nonDuplicatedCarNames = Arrays.stream(carNames).collect(Collectors.toSet());
        return nonDuplicatedCarNames.size() < carNames.length;
    }
}
