package racingcar.constant;

public enum OutputMessage {

    RESULT("실행 결과"),
    FINAL_WINNERS("최종 우승자");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
