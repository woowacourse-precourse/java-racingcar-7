package racingcar.presentation.enums;

public enum ExceptionMessage {
    EMPTY_NAME_EXCEPTION("이름이 비어있습니다."),
    OVER_5_CAR_NAME_LENGTH("이름의 길이가 5 초과입니다.");

    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
