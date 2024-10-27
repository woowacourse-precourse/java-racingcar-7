package racingcar.model.Util;

public sealed interface DelimiterSymbols permits StringGenerator, Parser {
    String STANDARD_DELIMITER = ",";
}
