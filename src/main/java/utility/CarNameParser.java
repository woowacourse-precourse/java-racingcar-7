package utility;

import constants.AppConstants;
import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public static List<String> parseCarNames(String carNamesAsString) {
        return Arrays.stream(carNamesAsString.split(AppConstants.NAME_DELIMITER)).toList();
    }
}
