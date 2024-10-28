package racingcar.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.Message.ErrorMessage;

public class CarsValidator {
    public static void validate(List<String> names) {
        validateExistence(names);
        validateNoDuplicates(names);
    }

    private static void validateExistence(List<String> names) {
        if (isEmpty(names)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_NO_CARS);
        }
    }

    private static boolean isEmpty(List<String> names) {
        return names == null || names.isEmpty();
    }

    private static void validateNoDuplicates(List<String> names) {
        if (hasDuplicates(names)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_DUPLICATE_NAME);
        }
    }

    private static boolean hasDuplicates(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        return uniqueNames.size() != names.size();
    }
}
