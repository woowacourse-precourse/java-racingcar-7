package racingcar.util.parser;

public class InputSplitter implements InputParser {
    private static final String DELIMETER = ",";

    @Override
    public String[] parse(String input) {
        return input.split(DELIMETER);
    }
}
