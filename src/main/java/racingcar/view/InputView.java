package racingcar.view;

import static racingcar.constant.ExceptionMessage.CAR_NAME_NOT_ALLOW_SPACE;
import static racingcar.constant.ExceptionMessage.TRY_COUNT_MUST_BE_NUMBER;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DELIMITER = ",";
    private static final int SPLIT_INCLUDE_LAST_SPACE = -1;

    private InputView() {
    }

    public static List<String> carNames() {
        return splitNames(input());
    }

    protected static List<String> splitNames(String input) {
        List<String> splitNames = Arrays.stream(input.split(DELIMITER, SPLIT_INCLUDE_LAST_SPACE)).toList();
        validateNames(splitNames);
        return splitNames;
    }

    private static void validateNames(List<String> splitNames) {
        if (splitNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(CAR_NAME_NOT_ALLOW_SPACE.getMessage());
        }
    }

    public static int tryCount() {
        return convertToInt(input());
    }

    protected static int convertToInt(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_NUMBER.getMessage());
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
