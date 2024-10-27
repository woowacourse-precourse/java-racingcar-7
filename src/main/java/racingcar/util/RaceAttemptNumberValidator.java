package racingcar.util;

import racingcar.exception.util.RaceAttemptNumberValidatorErrorMessages;

public class RaceAttemptNumberValidator {
    public static int validate(String input) {
        int raceAttemptNumber;
        try {
            raceAttemptNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // 숫자가 아닐 경우 예외 발생
            throw new IllegalArgumentException(RaceAttemptNumberValidatorErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
        }

        // 시도 횟수가 0 이하일 경우 예외 발생
        if (raceAttemptNumber <= 0) {
            throw new IllegalArgumentException(RaceAttemptNumberValidatorErrorMessages.NUMBER_TOO_LOW.getMessage());
        }

        return raceAttemptNumber;
    }
}
