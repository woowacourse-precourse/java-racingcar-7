package racingcar.message;

public enum ErrorMessage {

    BLANK_INPUT_ERROR("[ERROR] 빈 문자열을 입력하실 수 없습니다. 다시 입력해주세요.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
