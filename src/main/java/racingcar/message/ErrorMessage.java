package racingcar.message;

public enum ErrorMessage {
    INVALID_NAME_LENGTH("자동차 이름은 5글자를 초과할 수 없습니다."),

    ;

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
