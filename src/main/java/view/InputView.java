package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER_ERROR_MESSAGE = "올바른 구분자를 입력해야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 이름을 입력해야 합니다.";
    private static final String EMPTY_ERROR_MESSAGE = "올바른 값을 입력해야 합니다.";
    private static final String CAR_NUMBER_ERROR_MESSAGE = "자동차는 2개 이상을 입력해야 합니다.";
    private static final String TRY_COUNT_NOT_NUMBER_ERROR_MESSAGE = "시도 횟수는 숫자를 입력해야 합니다.";
    private static final String TRY_COUNT_NUMBER_ZERO_ERROR_MESSAGE = "시도 횟수는 0보다 큰 숫자를 입력해야 합니다.";
    private static final String TRY_COUNT_NUMBER_MINUS_ERROR_MESSAGE = "시도 횟수는 양수를 입력해야 합니다.";

    private static final String DELIMITER = ",";
    private static final String OTHER_DELIMITER_REGEX = "[^,\\w\\s]";
    private static final Integer MINIMUM_CAR_NUMBER = 2;
    private static final String NUMBER_REGEX = "\\d+";

    public static List<Car> getCarNames() {
        String input = Console.readLine();
        validateEmpty(input);
        validateDelimiter(input);
        String[] carNames = input.split(DELIMITER);
        validateInputSize(carNames);
        validateDuplicate(carNames);
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public static int getTryCount() {
        String input = Console.readLine();
        validateTryCountNumber(input);
        validateTryCountZero(input);
        validateTryCountMinusNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateTryCountNumber(final String input) {
        if(!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(TRY_COUNT_NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateTryCountZero(final String input) {
        if(Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_ZERO_ERROR_MESSAGE);
        }
    }

    private static void validateTryCountMinusNumber(final String input) {
        if(Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_MINUS_ERROR_MESSAGE);
        }
    }

    private static void validateDelimiter(final String input) {
        Pattern pattern = Pattern.compile(OTHER_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicate(final String[] carNames) {
        Boolean result = Arrays.stream(carNames)
                .distinct()
                .count() != carNames.length;

        if (result) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void validateEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    private static void validateInputSize(final String[] carNames) {
        if (carNames.length < MINIMUM_CAR_NUMBER) {
            throw new IllegalArgumentException(CAR_NUMBER_ERROR_MESSAGE);
        }
    }
}
