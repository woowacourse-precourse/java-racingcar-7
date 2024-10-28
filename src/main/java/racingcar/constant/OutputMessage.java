package racingcar.constant;

public enum OutputMessage {
    CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TOTAL_RACING_ROUND("시도할 횟수는 몇 회인가요?"),
    RACE_START("====Start Race!===="),
    CELEBRATE_WIN("===우승을 축하합니다!===");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getMessage() {
        return outputMessage;
    }
}
