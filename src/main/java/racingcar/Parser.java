package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Parser {

    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String CAR_NAME_LENGTH_EXCEPTION_MSG = "자동차 이름은 한 글자 이상, 5자 이하여야 합니다.";
    public static final String ATTEMPTS_RANGE_EXCEPTION_MSG = "유효한 숫자 범위를 벗어났습니다.";

    private static boolean validateCarName(String carName) {
        return carName != null && !carName.isEmpty() && carName.length() <= CAR_NAME_MAX_LENGTH;
    }

    public static CarGroup parseCarNames(String input) {
        return new CarGroup(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(carName -> {
                    if (!validateCarName(carName)) {
                        throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MSG);
                    }
                    return new Car(carName);
                })
                .collect(Collectors.toList()));
    }

    public static int parseAttempts(String input) {
        int attempts = 0;
        try {
            attempts = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPTS_RANGE_EXCEPTION_MSG);
        }

        if (attempts < 0) {
            throw new IllegalArgumentException(ATTEMPTS_RANGE_EXCEPTION_MSG);
        }
        return attempts;
    }
}
