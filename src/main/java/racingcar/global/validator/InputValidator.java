package racingcar.global.validator;

import racingcar.global.exception.ExceptionType;
import racingcar.global.parser.InputParser;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{1,5}$");

    public static List<String> validCarNames(String input) {
        List<String> carNames = InputParser.splitByComma(input);

        carNames.forEach(InputValidator::validCarName);

        return carNames;
    }

    public static void validCarName(String name) {
        if (!CAR_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(ExceptionType.INVALID_CAR_NAME.message());
        }
    }

    public static int validRepeatNum(String repeatNum) {
        int num;
        try {
            num = Integer.parseInt(repeatNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.INVALID_REPEAT_NUM.message());
        }
        return num;
    }
}
