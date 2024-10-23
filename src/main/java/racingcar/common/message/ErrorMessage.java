package racingcar.common.message;

import static racingcar.common.constant.SystemConstant.ERROR_PREFIX;

public class ErrorMessage {

    public static String SHOULD_NOT_BE_NULL = String.format(ERROR_PREFIX, "NULL이여서는 안됩니다.");

    private ErrorMessage() {}
}
