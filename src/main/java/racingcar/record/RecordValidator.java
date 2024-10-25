package racingcar.record;

import racingcar.constant.Strings;

public class RecordValidator {
    private static final RecordValidator RECORD_VALIDATOR = new RecordValidator();

    private RecordValidator() {

    }

    public static RecordValidator getInstance() {
        return RECORD_VALIDATOR;
    }

    public void numberCheck(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(Strings.IS_NOT_NUMBER.getMessage());
            }
        }
    }

    public void validTryTimeCheck(int tryTimes) {
        if (tryTimes <= 0) {
            throw new IllegalArgumentException(Strings.PUT_OVER_ZERO.getMessage());
        }
    }
}
