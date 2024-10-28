package racingcar.racing.utils;

import static racingcar.racing.utils.ExceptionMessages.INVALID_ATTEMPT_EXCEPTION_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public static List<String> parseCarNames(String inputCar) {
        List<String> carNames = Arrays.stream(inputCar.split(",")).toList();
        return carNames.stream()
                .filter(carName -> !carName.equals(""))
                .collect(Collectors.toList());
    }

    public static int parseAttemptNumber(String inputAttemptNumber) {
        try {
            return Integer.parseInt(inputAttemptNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_EXCEPTION_MESSAGE);
        }
    }
}
