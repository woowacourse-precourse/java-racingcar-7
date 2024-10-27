package racingcar.message;

public enum ErrorMessage {
    INVALID_NAME_LENGTH("자동차 이름은 5글자를 초과할 수 없습니다."),
    INVALID_NUMBER("숫자를 입력해주세요."),
    INVALID_NAME_INPUT("이름은 비어있거나 공백일 수 없습니다."),
    DUPLICATE_NAME("자동차 이름은 중복될 수 없습니다."),

    ;

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
