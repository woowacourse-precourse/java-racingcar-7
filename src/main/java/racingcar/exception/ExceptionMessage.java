package racingcar.exception;

public enum ExceptionMessage {
    INPUT_VALUE_IS_NULL("자동차 이름 또는 경기횟수를 입력해주세요."),
    TRY_COUNT_IS_NOT_NUMBER("경기횟수는 숫자를 입력해주세요."),
    TRY_COUNT_IS_ZERO("경기 횟수는 1 이상의 수를 입력해주세요."),
    CAR_NAME_IS_DUPLE("자동차차 이름이 중복됩니다."),
    CAR_NAME_INVALID_LENGTH("자동차 이름의 길이를 지켜주세요"),
    CAR_NAME_INCLUDE_BLANK("자동차 이름에 공백을 제외시켜주세요."),
    CAR_NAME_INCLUDE_INVALID_STRING("한글, 영어, 숫자로만 입력해주세요.");

    private String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
