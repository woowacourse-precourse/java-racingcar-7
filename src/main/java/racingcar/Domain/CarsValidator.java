package racingcar.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.Message.ErrorMessage;

public class CarsValidator {
    public static void validate(List<String> names) {
        validateDuplicate(names);
        validateEmpty(names);

    }

    private static void validateEmpty(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_NO_CARS);
        }
    }

    private static void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_DUPLICATE_NAME);
        }

    }
}
