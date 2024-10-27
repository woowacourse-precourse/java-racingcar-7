package racingcar.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Validator {

    public void validateNames(List<String> names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            if (!set.add(name)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
            }
            validateEmptyName(name);
            validateNameLimit(name);
        }
    }

    private void validateNameLimit(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_OVER_LIMIT.getMessage());
        }
    }

    private void validateEmptyName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
        }
    }


    public int validateCount(String count) {
        try {
           return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NOT_NUMBER.getMessage());
        }
    }
}
