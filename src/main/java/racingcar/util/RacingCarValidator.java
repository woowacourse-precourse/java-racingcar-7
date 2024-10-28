package racingcar.util;

import static racingcar.constant.RacingCarStatic.MAX_CAR_NAME_LENGTH;
import static racingcar.exception.RacingCarErrorCode.CAR_NAME_CANNOT_BE_BLANK;
import static racingcar.exception.RacingCarErrorCode.CAR_NAME_CANNOT_OVER_LIMIT;
import static racingcar.exception.RacingCarErrorCode.RACE_COUNT_CANNOT_BE_DECIMAL;
import static racingcar.exception.RacingCarErrorCode.RACE_COUNT_CANNOT_BE_NEGATIVE_NUMBER;
import static racingcar.exception.RacingCarErrorCode.RACE_COUNT_MUST_BE_NUMBER;

import java.math.BigInteger;

public class RacingCarValidator {

    public void validateCarName(String carName) {
        carNameBlankValidate(carName);
        carNameLengthValidate(carName);
    }

    public void validateRaceCount(String raceCount) {
        raceCountDecimalValidate(raceCount);
        raceCountNegativeNumberValidate(raceCount);
        raceCountParsingValidate(raceCount);
    }

    private void carNameBlankValidate(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_BE_BLANK.getErrorMsg());
        }
    }

    private void carNameLengthValidate(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_OVER_LIMIT.getErrorMsg() + " : " + carName);
        }
    }

    private void raceCountDecimalValidate(String raceCount) {
        if (raceCount.contains(".")) {
            throw new IllegalArgumentException(RACE_COUNT_CANNOT_BE_DECIMAL.getErrorMsg() + " : " + raceCount);
        }
    }

    private void raceCountNegativeNumberValidate(String raceCount) {
        if (raceCount.contains("-")) {
            throw new IllegalArgumentException(RACE_COUNT_CANNOT_BE_NEGATIVE_NUMBER.getErrorMsg() + " : " + raceCount);
        }
    }

    private void raceCountParsingValidate(String raceCount) {
        try {
            BigInteger number = new BigInteger(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACE_COUNT_MUST_BE_NUMBER.getErrorMsg() + " : " + raceCount);
        }
    }
}
