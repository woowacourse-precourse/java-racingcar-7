package racingcar.util;

public enum ErrorMessage {
    CAR_NAME_OVER_FIVE("자동차 이름은 다섯글자 이하로 입력해주세요."),
    CAR_NAME_EMPTY("한글자 이상의 자동차 이름을 입력해주세요."),
    CAR_NAME_DUPLICATED("자동차 이름은 중복될 수 없습니다."),
    TRIAL_IS_NOT_NUMBER("시도 횟수는 0 이상의 정수이어야 합니다."),
    TRIAL_UNDER_ZERO("시도 횟수는 0 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
