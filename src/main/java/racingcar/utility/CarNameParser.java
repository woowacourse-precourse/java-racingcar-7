package racingcar.utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameParser {

    public static final String NAME_DELIMITER = ",";

    public static List<String> parseCarNames(String carNamesAsString) {
        if (carNamesAsString == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(carNamesAsString.split(NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
