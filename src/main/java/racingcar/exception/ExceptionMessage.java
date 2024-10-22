package racingcar.exception;

public enum ExceptionMessage {
    BLANK_NAME("자동차의 이름은 공백이 될 수 없습니다."),
    OUT_OF_NAME_LENGTH("자동차의 이름은 5자를 초과하였습니다."),
    ILLEGAL_POSITION("자동차의 위치는 음수가 될 수 없습니다.");

    private final String message;
    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
