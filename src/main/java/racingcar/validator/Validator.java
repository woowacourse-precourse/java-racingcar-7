package racingcar.validator;

import static racingcar.exception.ErrorMessage.INVALID_COUNT_RANGE;
import static racingcar.exception.ErrorMessage.INVALID_NAME_COUNT;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.NAME_DUPLICATE;
import static racingcar.exception.ErrorMessage.NOT_INTEGER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.RaceException;

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
                throw new RaceException(INVALID_COUNT_RANGE);
            }
        } catch (NumberFormatException e) {
            throw new RaceException(NOT_INTEGER);
        }
    }

    private static void nameLengthValidate(List<String> names) {
        names.forEach((name) -> {
            if (name.length() > 5) {
                throw new RaceException(INVALID_NAME_LENGTH);
            }
        });
    }

    private static void nameCountValidate(List<String> names) {
        if (names.size() < 2) {
            throw new RaceException(INVALID_NAME_COUNT);
        }
    }

    private static void nameDuplicateValidate(List<String> names) {
        Set<String> checkDuplicate = new HashSet<>();
        names.forEach(name -> {
            if (!checkDuplicate.add(name)) {
                throw new RaceException(NAME_DUPLICATE);
            }
        });
    }
}
