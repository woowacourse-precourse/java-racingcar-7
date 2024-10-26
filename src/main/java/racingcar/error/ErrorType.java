package racingcar.error;

public enum ErrorType {
    CAR_NAME_LENGTH_ERROR("이름은 %d자 이상 %d자 이하만 가능합니다."),
    CAR_NAME_DUPLICATE_ERROR("자동차 이름은 중복될 수 없습니다."),
    MIN_TRAIL_NUMBER("시도 횟수는 1 이상이여야 합니다."),
    INVALID_FORMAT_TRAIL_NUMBER_ERROR("시도 횟수는 숫자를 입력해주세요.");

    private final String message;

    ErrorType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
