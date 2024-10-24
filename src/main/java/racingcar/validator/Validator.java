package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {
    public static void namesValidate(List<String> names) {
        nameLengthValidate(names);
        nameDuplicateValidate(names);
        nameCountValidate(names);
    }

    public static void countValidate(String count) {
        try {
            int cnt = Integer.parseInt(count);
            if (cnt < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    private static void nameLengthValidate(List<String> names) {
        names.forEach((name) -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        });
    }

    private static void nameCountValidate(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private static void nameDuplicateValidate(List<String> names) {
        Set<String> checkDuplicate = new HashSet<>();
        names.forEach(name -> {
            if (!checkDuplicate.add(name)) {
                throw new IllegalArgumentException();
            }
        });
    }
}
