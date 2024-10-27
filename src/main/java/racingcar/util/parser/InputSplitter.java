package racingcar.util.parser;

import java.util.Arrays;
import racingcar.model.CarNames;

public class InputSplitter implements InputParser {
    private static final String DELIMETER = ",";

    @Override
    public CarNames parse(String input) {
        return new CarNames(Arrays.asList(input.split(DELIMETER)));
    }
}
