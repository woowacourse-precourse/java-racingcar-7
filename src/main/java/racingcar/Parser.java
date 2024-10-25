package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Parser {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private static boolean validateCarName(String carName) {
        return carName != null && !carName.isEmpty() && carName.length() <= CAR_NAME_MAX_LENGTH;
    }

    public static CarGroup parseCarNames(String input) {
        return new CarGroup(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(carName -> {
                    if (!validateCarName(carName)) {
                        throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }

        if (attempts < 0) {
            throw new IllegalArgumentException();
        }
        return attempts;
    }
}
