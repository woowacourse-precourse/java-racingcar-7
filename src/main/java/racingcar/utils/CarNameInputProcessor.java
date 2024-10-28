package racingcar.utils;

import static racingcar.exception.ExceptionMessage.*;

import java.util.*;
import java.util.stream.Collectors;

public class CarNameInputProcessor {

    private CarNameInputProcessor() {
    }

    public static List<String> splitCarNames(String carNames) {
        validateInput(carNames);
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateInput(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
        if (carNames.trim().startsWith(",") || carNames.trim().endsWith(",")) {
            throw new IllegalArgumentException(INVALID_COMMA_POSITION);
        }
    }
}
