package racingcar.message;

public enum ErrorMessage implements MessageProvider {
    CAR_NAME_OVERSIZE_ERROR("자동차 이름은 5글자를 넘을 수 없습니다."),
    CAR_NAME_NULL_ERROR("자동차 이름을 입력하지 않았습니다."),
    TRY_NUMBER_IS_NULL_ERROR("입력된 시도 횟수가 없습니다."),
    TRY_NUMBER_IS_NOT_INT_ERROR("입력된 시도 횟수가 숫자가 아닙니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
