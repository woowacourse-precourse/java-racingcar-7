package parser;

import java.util.Arrays;

public class CarNameParser {

    public static void validateCarNamesAsString(String carNameAsString) {
        validateStringLength(carNameAsString);
        validateCarNamesLength(carNameAsString);
    }

    private static void validateStringLength(String carNameAsString) {
        if (carNameAsString.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateCarNamesLength(String carNamesAsString) {
        if (Arrays.stream(carNamesAsString.split(",")).anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }
}
