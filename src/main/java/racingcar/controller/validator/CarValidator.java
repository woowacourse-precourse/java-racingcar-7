package racingcar.controller.validator;

import static racingcar.exception.ErrorBase.CAR_COUNT_EXCEEDS_LIMIT;
import static racingcar.exception.ErrorBase.CAR_NAME_IS_BETWEEN_ONE_AND_FIVE;

import java.util.List;
import java.util.stream.Stream;
import org.junit.platform.commons.util.StringUtils;

public class CarValidator extends Validator<List<String>>{
    public static final int MAX_CARS = 1000;
    public static final int NAME_LENGTH = 5;

    @Override
    protected List<String> parseInput(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .peek(CarValidator::validateCarNameLength)
                .toList();
    }

    @Override
    protected void validateRange(List<String> names) {
        if (names.isEmpty() || names.size() > MAX_CARS) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEEDS_LIMIT.getMessage());
        }
    }

    private static void validateCarNameLength(String name) {
        if (StringUtils.isBlank(name) || name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_IS_BETWEEN_ONE_AND_FIVE.getMessage());
        }
    }
}
