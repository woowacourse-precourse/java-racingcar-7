package racingcar.view;


public enum OutputMessage {
    RESULT_MESSAGE("\n실행 결과"),
    CAR_POSITION("%s : %s"),
    WINNERS("최종 우승자 : %s");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}