package racingcar.service.utils;

import racingcar.view.messages.ErrorMessageEnum;

public class ExceptionUtils {
    public static void throwIllegalArgumentException(ErrorMessageEnum errorMessageEnum) {
        throw new IllegalArgumentException(errorMessageEnum.getErrorMessage());
    }
}
