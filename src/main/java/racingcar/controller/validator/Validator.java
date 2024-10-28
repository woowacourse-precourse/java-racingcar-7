package racingcar.controller.validator;

import static racingcar.exception.InputErrorCode.DUPLICATE_NAME_ERROR;
import static racingcar.exception.InputErrorCode.INPUT_NAME_ERROR;
import static racingcar.exception.InputErrorCode.INPUT_NAME_LENGTH_ERROR;
import static racingcar.exception.InputErrorCode.INPUT_TIMES_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private Validator() {
    }

    public static void validateNameList(List<String> nameList) {
        Set<String> nameSet = new HashSet<>();
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(INPUT_NAME_LENGTH_ERROR.message());
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException(INPUT_NAME_ERROR.message());
            }
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(DUPLICATE_NAME_ERROR.message());
            }
        }
    }

    public static void validateTimeInput(long times) {
        if (times < 0) {
            throw new IllegalArgumentException(INPUT_TIMES_ERROR.message());
        }
    }
}
