package racingcar.record;

import static racingcar.constant.Strings.*;

public class RecordValidator {
    private static final RecordValidator RECORD_VALIDATOR = new RecordValidator();

    private RecordValidator() {

    }

    public static RecordValidator getInstance() {
        return RECORD_VALIDATOR;
    }

    public void blankCheck(String tryTimes){
        if(tryTimes.isEmpty()){
            throw new IllegalArgumentException(NOT_EXIST.getMessage());
        }
    }

    public void numberCheck(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(IS_NOT_NUMBER.getMessage());
            }
        }
    }

    public void validTryTimeCheck(int tryTimes) {
        if (tryTimes <= 0) {
            throw new IllegalArgumentException(PUT_OVER_ZERO.getMessage());
        }
    }
}
