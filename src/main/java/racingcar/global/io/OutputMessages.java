package racingcar.global.io;

public enum OutputMessages {
    EXECUTION_OUTPUT_MESSAGE("실행 결과"),
    FINAL_WINNER_OUTPUT_MESSAGE("최종 우승자 :");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }
}
