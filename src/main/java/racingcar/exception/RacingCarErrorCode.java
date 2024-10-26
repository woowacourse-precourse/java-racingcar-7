package racingcar.exception;

import static racingcar.constant.RacingCarStatic.MAX_CAR_NAME_LENGTH;

public enum RacingCarErrorCode {

    CAR_NAME_CANNOT_OVER_LIMIT("자동차의 이름은 " + MAX_CAR_NAME_LENGTH + "자를 넘을 수 없습니다.");

    private final String errorMsg;

    RacingCarErrorCode(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
