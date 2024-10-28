package racingcar.controller.validator;

import static racingcar.exception.ErrorBase.CAR_COUNT_EXCEEDS_LIMIT;
import static racingcar.exception.ErrorBase.CAR_NAME_IS_BETWEEN_ONE_AND_FIVE;
import static racingcar.exception.ErrorBase.INPUT_IS_EMPTY;

import java.util.List;
import java.util.stream.Stream;
import org.junit.platform.commons.util.StringUtils;

public class ValidateCar {
    public static final int MAX_CARS = 1000;
    public static final int NAME_LENGTH = 5;

    public static List<String> validateName(String input) {
        validateBlankInput(input);

        List<String> names = Stream.of(input.split(","))
                .map(String::trim)
                .peek(ValidateCar::validateCarNameLength)
                .toList();

        validateCarCount(names);

        return names;
    }

    private static void validateBlankInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY.getMessage());
        }
    }

    private static void validateCarNameLength(String name) {
        if (StringUtils.isBlank(name)){
            throw new IllegalArgumentException(INPUT_IS_EMPTY.getMessage());
        }

        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_IS_BETWEEN_ONE_AND_FIVE.getMessage());
        }
    }

    private static void validateCarCount(List<String> names) {
        if (names.isEmpty() || names.size() > MAX_CARS) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEEDS_LIMIT.getMessage());
        }
    }
}
