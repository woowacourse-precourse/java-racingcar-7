package racingcar.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.Util.Exception.ErrorMessage;

public class NameValidation {
    public static boolean isLongName(List<String> names) {
        for (String name : names)
        {
            if (name.length() > 5) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWhitespace(List<String> names) {
        for (String name : names)
        {
            if (name != null && name.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(List<String> names) {
        for (String name : names)
        {
            if (name != null && name.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicate(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        return uniqueNames.size() != carNames.size();
    }

    public static void validateName(String name) {
        if (NameValidation.isEmpty(List.of(name))) {
            throw new IllegalArgumentException(ErrorMessage.NAME_EMPTY.getMessage());
        }
        if (NameValidation.isWhitespace(List.of(name))) {
            throw new IllegalArgumentException(ErrorMessage.NAME_WHITESPACE.getMessage());
        }
    }
}
