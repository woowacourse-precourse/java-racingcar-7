package racingcar.constant;

public enum OutputMessage {
    GAME_START_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : "),
    POSITION_MARKER("-"),
    NAME_POSITION_SEPARATOR(" : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
