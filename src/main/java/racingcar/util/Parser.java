package racingcar.util;

import racingcar.global.Symbol;

public class Parser {

    public static String[] splitWithDelimiter(String input) {
        return input.split(
                Symbol.NAME_DELIMITER.getSymbol()
        );
    }
}
