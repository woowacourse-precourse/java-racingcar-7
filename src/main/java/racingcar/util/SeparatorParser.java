package racingcar.util;

public class SeparatorParser {

    private static final String INPUT_DELIMITER = ",";

    public String[] parseCarNames(String inputCarNames) {
        return inputCarNames.split(INPUT_DELIMITER);
    }

}
