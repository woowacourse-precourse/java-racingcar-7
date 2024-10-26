package racingcar.game.io;

public enum OutputMessage {
    CAR_INPUT_NAVIGATE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_COUNT_INPUT_NAVIGATE("시도할 횟수는 몇 회인가요?"),
    WINNER("최종 우승자 : %s"),
    CAR_MOVE_PROGRESS("%s : %s");

    private final String template;

    OutputMessage(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}