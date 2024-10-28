package racingcar.util.parser;

import java.util.Arrays;
import java.util.List;

public class BasicRacingCarNameParser implements RacingCarNameParser {
    private static final String CAR_NAME_DELIMITER = ",";

    @Override
    public List<String> parseNamesStringToList(String carNames) {
        String[] splitCarNames = splitCarNames(carNames);
        return Arrays.stream(splitCarNames)
                .map(this::trimLeadingAndTrailingWhitespace)
                .toList();
    }

    private String trimLeadingAndTrailingWhitespace(String carName) {
        return carName.strip();
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }
}
