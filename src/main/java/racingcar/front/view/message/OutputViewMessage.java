package racingcar.front.view.message;

public enum OutputViewMessage {
    RACE_RESULT_MESSAGE("실행 결과"), WINNER_MESSAGE("최종 우승자 : ");

    OutputViewMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}

