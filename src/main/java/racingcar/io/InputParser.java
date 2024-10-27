package racingcar.io;

public class InputParser {
    private static final String NAME_DELIMITER = ",";

    public String[] parseCarNames(String input) {
        return input.split(NAME_DELIMITER, -1);
    }
}
