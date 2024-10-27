package racingcar.util;

import racingcar.global.Symbol;

public class Parser {

    public static String[] splitWithDelimiter(String input) {
        return input.split(
                Symbol.NAME_DELIMITER.getSymbol()
        );
    }

    public static int parseInt(String input) {
        InputValidator.validateNumeric(input);

        return Integer.parseInt(input);
    }
}
