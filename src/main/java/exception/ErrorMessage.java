package exception;

public enum ErrorMessage {
    NAME_LENGTH_EXCESS("[ERROR] 자동차 이름이 5글자를 초과하였습니다."),
    NAME_EMPTY("[ERROR] 자동차 이름이 비어있습니다."),
    NAME_DUPLICATE("[ERROR] 자동차 이름이 중복되었습니다."),
    INVALID_ATTEMPTS_RANGE("[ERROR] 시도 횟수는 1회 이상이어야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}
