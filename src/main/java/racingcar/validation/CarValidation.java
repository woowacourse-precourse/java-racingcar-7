package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidation {
    private static final String NAME_SEPARATOR = ",";
    private static final String NAME_EMPTY = "";

    public static boolean validateCarNameSeparator(String carNames) {
        return !carNames.contains(NAME_SEPARATOR);
    }

    public static boolean validateCarNameDuplication(List<String> carNames) {
        Set<String> notDuplicateCarName = new HashSet<>(carNames);
        return notDuplicateCarName.size() != carNames.size();
    }

    public static boolean validateCarNameEmpty(List<String> carNames) {
        return carNames.contains(NAME_EMPTY);
    }
}
