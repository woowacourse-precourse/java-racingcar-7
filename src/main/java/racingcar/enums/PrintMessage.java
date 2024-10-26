package racingcar.enums;

public enum PrintMessage {
    ENTER_CARS_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ENTER_TRIAL_COUNT_PROMPT("시도할 횟수는 몇 회인가요?"),
    PRINT_RACE_RESULT("실행 결과"),
    PRINT_FINAL_WINNER("최종 우승자 : %s");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatWinner(String winners) {
        return PRINT_FINAL_WINNER.getMessage().formatted(winners);
    }
}
