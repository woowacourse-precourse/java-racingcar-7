package racingcar.validator;

import java.util.List;

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
}
