package racingcar.util;

import java.util.Arrays;
import java.util.List;

import static racingcar.constants.RacingSymbols.NAME_DELIMITER;

public class CarNameParser {
    public List<String> parse(String carNames) {
        return Arrays.stream(carNames.split(NAME_DELIMITER))
                .toList();
    }
}
