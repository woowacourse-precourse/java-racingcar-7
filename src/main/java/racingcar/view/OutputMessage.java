package racingcar.view;

import racingcar.constant.Message;

public enum OutputMessage implements Message {
    TYPE_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?"),
    RUN_RESULT("실행 결과"),
    ROUND_RESULT("%s : %s"),
    FINAL_WINNER("최종 우승자 : %s");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(String... args) {
        return String.format(message, (Object[]) args);
    }
}
