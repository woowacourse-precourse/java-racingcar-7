package racingcar.View.constant;

public enum OutputMessage {
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_START_MESSAGE("실행 결과"),
    START_COUNT("시도할 횟수는 몇 회인가요?"),
    FINAL_WINNER("최종 우승자 : ");
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
