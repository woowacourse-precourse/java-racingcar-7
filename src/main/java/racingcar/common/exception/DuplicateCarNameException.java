package racingcar.common.exception;

import racingcar.common.constant.MessageConstants;

public class DuplicateCarNameException extends IllegalArgumentException {

    public DuplicateCarNameException() {
        super(MessageConstants.DUPLICATE_CAR_NAME_ERROR);
    }
}
