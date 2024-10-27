package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.DomainConstants.CAR_NAME_DEFAULT_DELIMITER;

public class CarNameParser {
    private String delimiter = CAR_NAME_DEFAULT_DELIMITER;
    public List<String> parse(String input) {
        return Arrays.asList(input.split(delimiter));
    }
}
