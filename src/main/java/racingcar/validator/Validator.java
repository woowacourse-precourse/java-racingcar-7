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
}
