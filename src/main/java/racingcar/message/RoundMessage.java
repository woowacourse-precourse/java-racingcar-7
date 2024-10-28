package racingcar.message;

public enum RoundMessage {

    ROUND_START_MESSAGE("실행 결과");

    private final String message;

    RoundMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
