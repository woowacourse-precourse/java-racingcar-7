package racingcar.util;

import java.util.regex.Pattern;

import static racingcar.util.Constants.ROUND_NUM_WRONG_ERROR;

public class RoundValidator {
    public String validateRoundNum;

    public String validate(String roundNum) {
        validateRoundNum = roundNum;
        isInt();
        return validateRoundNum;
    }

    private void isInt() {
        // String 형식 확인: 앞-0이 아닌 숫자, 이후-숫자
        if (!Pattern.compile("^[1-9][0-9]*$").matcher(validateRoundNum).matches()) {
            throw new IllegalArgumentException(ROUND_NUM_WRONG_ERROR.getMessage());
        }
    }
}
