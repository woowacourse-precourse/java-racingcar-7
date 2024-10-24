package racingcar.common.message;

import static java.lang.String.format;
import static racingcar.common.constant.SystemConstant.ERROR_PREFIX;

public class ErrorMessage {

    public static String SHOULD_NOT_BE_NULL = format(ERROR_PREFIX, "NULL이여서는 안됩니다.");
    public static String LAP_COUNT_SHOULD_NOT_BE_MINUS = format(ERROR_PREFIX, "남은 Lap의 수는 0보다 크거나 같아야 합니다.");
    public static String EMPTY_INPUT = format(ERROR_PREFIX, "값을 입력하지 않으셨습니다.");
    public static String NOT_ENOUGH_CAR = format(ERROR_PREFIX, "최소 %d명 이상의 자동차가 입력되어야 합니다.");
    public static String CAR_NAME_LENGTH_EXCEED = format(ERROR_PREFIX, "자동차 이름은 %d글자를 넘을 수 없습니다.");

    private ErrorMessage() {
    }
}
