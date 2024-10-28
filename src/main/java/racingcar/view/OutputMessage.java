package racingcar.view;

public enum OutputMessage {
    RESULT_SEPARATOR(" : "),
    MOVE_MARK("-"),
    WINNER("최종 우승자");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
