package racingcar.util;

import static racingcar.util.Constants.INPUT_DELIMITER;
import static racingcar.util.Constants.MINIMUM_RACING_CAR_NEEDED;
import static racingcar.util.Constants.CONSECUTIVE_DELIMITER;
import static racingcar.util.Constants.NAME_LENGTH_LIMIT;
import static racingcar.util.message.ExceptionMessage.DELIMITER_POSITION_INCORRECT;
import static racingcar.util.message.ExceptionMessage.DUPLICATED_NAMES;
import static racingcar.util.message.ExceptionMessage.NAME_LENGTH_NOT_VALID;
import static racingcar.util.message.ExceptionMessage.NEED_MULTIPLE_RACING_CAR;
import static racingcar.util.message.ExceptionMessage.TRIAL_COUNT_NOT_POSITIVE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Validator {

    public static List<String> validateInputString(String input) {
        if (input.isBlank() || isDelimiterUsedIncorrect(input)) {
            throw new IllegalArgumentException(DELIMITER_POSITION_INCORRECT.get());
        }
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .map(String::strip)
                .toList();
    }
    private static boolean isDelimiterUsedIncorrect(String input) {
        return input.startsWith(INPUT_DELIMITER)
                || input.endsWith(INPUT_DELIMITER)
                || input.contains(CONSECUTIVE_DELIMITER);
    }

    public static List<String> validateDuplicatedName(List<String> racerNames) {
        long distinctNameCount = racerNames.stream().distinct().count();

        if (distinctNameCount != racerNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAMES.get());
        }
        return Collections.unmodifiableList(racerNames);
    }

    public static String validateNameLength(String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_NOT_VALID.get());
        }
        return name;
    }

    public static void validateRacingCarCount(List<String> racerNames) {
        if (racerNames.size() < MINIMUM_RACING_CAR_NEEDED) {
            throw new IllegalArgumentException(NEED_MULTIPLE_RACING_CAR.get());
        }
    }

    public static Integer validateIntegerInput(String trialCount) {
        try {
            return Integer.parseInt(trialCount);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage(), e.fillInStackTrace());
        }
    }

    public static Integer validatePositive(Integer trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException(TRIAL_COUNT_NOT_POSITIVE.get());
        }
        return trialCount;
    }
}
