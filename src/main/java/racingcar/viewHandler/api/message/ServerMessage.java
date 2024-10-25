package racingcar.viewHandler.api.message;

public enum ServerMessage implements ApiMessage {
    서버_성공(new ExceptionMessageImpl("success", 200)),
    ;

    private final ApiMessage message;

    ServerMessage(ApiMessage message) {
        this.message = message;
    }

    public String getMessage() {
        return message.getMessage();
    }

    public Integer getCode() {
        return message.getCode();
    }
}
