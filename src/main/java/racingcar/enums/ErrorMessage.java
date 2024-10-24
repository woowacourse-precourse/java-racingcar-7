package racingcar.enums;

public enum ErrorMessage {
    INVALID_CAR_NAMES("자동차 이름은 5자 이하의 영어 대소문자 및 숫자로 구성해주세요."),
    DUPLICATED_NAMES("자동차 이름 목록에 중복이 존재합니다."),
    INVALID_TRIAL_COUNT("시도 횟수는 0 이상 1000 이하의 정수로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
