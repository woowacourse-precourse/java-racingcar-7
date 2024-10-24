package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

public final class Parser {
    public static List<String> parse(String input) {
        List<String> names = Arrays.stream(input.split(",")).map(String::trim).toList();
        Validator.namesValidate(names);
        return names;
    }
}
