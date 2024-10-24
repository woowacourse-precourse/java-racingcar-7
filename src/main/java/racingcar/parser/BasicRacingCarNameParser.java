package racingcar.parser;

import java.util.List;

public class BasicRacingCarNameParser implements RacingCarNameParser {
    private static final String CAR_NAME_DELIMITER = ",";

    @Override
    public List<String> parseNamesStringToList(String carNames) {
        return null;
    }

    private String trimLeadingAndTrailingWhitespace(String carName) {
        return carName.strip();
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }
}
