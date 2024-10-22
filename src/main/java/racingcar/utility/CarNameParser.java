package racingcar.utility;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public static final String NAME_DELIMITER = ",";

    public static List<String> parseCarNames(String carNamesAsString) {
        return Arrays.stream(carNamesAsString.split(NAME_DELIMITER)).toList();
    }
}
