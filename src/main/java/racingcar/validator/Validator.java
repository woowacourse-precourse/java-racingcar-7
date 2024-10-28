package racingcar.validator;

import racingcar.exception.EmptyNameException;
import racingcar.exception.OverLimitedNameException;
import static racingcar.constant.Constant.NAME_LENGTH_LIMIT;

public class Validator {

    private static Validator validator;

    private Validator(){}

    public static Validator getValidator() {
        if (validator == null) {
            validator = new Validator();
            return validator;
        }
        return validator;
    }

    // InputService()에서 carName(String)의 유효성 검사
    public void isValidName(String carName) {
        if (carName.isBlank()) {
            throw new EmptyNameException();
        }
        if (carName.length() > NAME_LENGTH_LIMIT) {
            throw new OverLimitedNameException();
        }
    }

    public Integer isValidRoundNumber(String totalRacingRound) {
        if (totalRacingRound.isBlank()) {
            return 0;
        }

        Integer validTotalRacingRound = Integer.parseInt(totalRacingRound);
        if (validTotalRacingRound < 0) {
            throw new NumberFormatException();
        }

        return validTotalRacingRound;
    }

}
