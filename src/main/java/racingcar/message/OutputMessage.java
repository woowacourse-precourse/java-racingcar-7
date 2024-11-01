package racingcar.message;

public enum OutputMessage {
    RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER("최종 우승자 : "),
    NO_WINNER("우승자가 없습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
