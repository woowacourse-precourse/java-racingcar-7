package racingcar.parser;

import java.util.List;

public class BasicRacingCarNameParser implements RacingCarNameParser {
    @Override
    public List<String> parseNamesStringToList(String carNames) {
        return null;
    }

    private String trimLeadingAndTrailingWhitespace(String carName) {
        return carName.strip();
    }
}
