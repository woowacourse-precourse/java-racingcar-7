package racingcar.exception;

import static racingcar.constant.RacingCarStatic.MAX_CAR_NAME_LENGTH;

public enum RacingCarErrorCode {

    CAR_NAME_CANNOT_OVER_LIMIT("자동차의 이름은 " + MAX_CAR_NAME_LENGTH + "자를 넘을 수 없습니다."),
    RACE_COUNT_CANNOT_BE_DECIMAL("주행 횟수에는 소수가 입력될 수 없습니다."),
    RACE_COUNT_CANNOT_BE_NEGATIVE_NUMBER("주행 횟수에는 음수가 입력될 수 없습니다."),
    RACE_COUNT_MUST_BE_NUMBER("주행 횟수는 반드시 숫자로 입력되어야 합니다.");

    private final String errorMsg;

    RacingCarErrorCode(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
