package racingcar.message;

public enum ErrorMessage {
    INVALID_NATURAL_NUMBER("자연수 값을 입력해주십시오."),
    INVALID_DUPLICATE_NAME("중복된 차 이름이 존재합니다."),
    INVALID_CAR_NAME_LENGTH("차의 이름은 한 글자 이상, 다섯 글자 이하여야 합니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}