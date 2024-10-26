package racingcar.util;

import static racingcar.constant.RacingCarStatic.MAX_CAR_NAME_LENGTH;
import static racingcar.exception.RacingCarErrorCode.CAR_NAME_CANNOT_OVER_LIMIT;
import static racingcar.exception.RacingCarErrorCode.RACE_COUNT_CANNOT_BE_DECIMAL;
import static racingcar.exception.RacingCarErrorCode.RACE_COUNT_CANNOT_BE_NEGATIVE_NUMBER;
import static racingcar.exception.RacingCarErrorCode.RACE_COUNT_MUST_BE_NUMBER;

import java.math.BigInteger;

public class RacingCarValidator {

    public void validateCarName(String carName) {

        //TODO : 아래것 다른 이름으로 분리하여 호출 (EX. 길이 검사)
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_OVER_LIMIT.getErrorMsg());
        }
    }

    public void validateRaceCount(String raceCount) {
        raceCountParsingValidate(raceCount);
        raceCountDecimalValidate(raceCount);
        raceCountNegativeNumberValidate(raceCount);
    }

    public void raceCountDecimalValidate(String raceCount) {
        if (raceCount.contains(".")) {
            throw new IllegalArgumentException(RACE_COUNT_CANNOT_BE_DECIMAL.getErrorMsg());
        }
    }

    public void raceCountNegativeNumberValidate(String raceCount) {
        if(raceCount.contains("-")) {
            throw new IllegalArgumentException(RACE_COUNT_CANNOT_BE_NEGATIVE_NUMBER.getErrorMsg());
        }
    }

    public void raceCountParsingValidate(String raceCount) {
        try {
            BigInteger number = new BigInteger(raceCount);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(RACE_COUNT_MUST_BE_NUMBER.getErrorMsg());
        }
    }
}
