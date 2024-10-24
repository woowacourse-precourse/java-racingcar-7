package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {
    public static void nameLengthValidate(List<String> names) {
        names.forEach((name) -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        });
    }

    public static void nameCountValidate(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    public static void nameDuplicateValidate(List<String> names) {
        Set<String> checkDuplicate = new HashSet<>();
        names.forEach(name -> {
            if (!checkDuplicate.add(name)) {
                throw new IllegalArgumentException();
            }
        });
    }
}
