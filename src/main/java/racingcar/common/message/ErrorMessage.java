package racingcar.common.message;

import static java.lang.String.format;
import static racingcar.common.constant.SystemConstant.ERROR_PREFIX;

public class ErrorMessage {

    public static String SHOULD_NOT_BE_NULL = format(ERROR_PREFIX, "NULL이여서는 안됩니다.");
    public static String LAP_COUNT_SHOULD_NOT_BE_MINUS = format(ERROR_PREFIX, "남은 Lap의 수는 0보다 크거나 같아야 합니다.");

    private ErrorMessage() {
    }
}
