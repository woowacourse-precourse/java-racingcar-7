package racingcar.utils;

import static racingcar.constant.SymbolType.CAR_NAME_DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.ParserValidator;

public final class Parser {
    public static List<String> parse(String input) {
        List<String> names = Arrays.stream(input.split(CAR_NAME_DELIMITER.getSymbol())).map(String::trim).toList();
        ParserValidator.namesValidate(names);
        return names;
    }
}
