package racingcar.validation;

import java.util.List;

public class CarValidation {
    private static final String NAME_SEPARATOR = ",";
    private static final String NAME_EMPTY = "";

    public static boolean validateCarNameSeparator(String carNames) {
        return !carNames.contains(NAME_SEPARATOR);
    }

    public static boolean validateCarNameEmpty(List<String> carNames) {
        return carNames.contains(NAME_EMPTY);
    }
}
