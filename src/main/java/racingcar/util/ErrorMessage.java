package racingcar.util;

public enum ErrorMessage {
    INPUT_STRING_DUPLICATE("입력 값이 중복되었습니다."),
    INPUT_STRING_NOT_NULL("입력 값이 null이 될 수 없습니다."),
    INPUT_CAR_NAME_IS_INCORRECT("입력한 차 이름이 올바르지 않습니다."),
    INPUT_CAR_NAME_BLANK("차 이름은 공백이 될 수 없습니다."),
    INPUT_WRONG_ROUND_NUMBER("입력한 라운드 수가 올바르지 않습니다."),
    EXCEPTION_NUMBER_RANGE("1회 이상 이동해야 합니다."),
    EXCEPTION_NUMERIC("자연수만 입력 가능합니다."),
    EXCEPTION_INT_RANGE("int 범위를 초과하는 입력은 불가능합니다.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}
