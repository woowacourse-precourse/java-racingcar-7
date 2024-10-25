package racingcar.front.view.message;

public enum InputViewMessage {
    INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"), RUN_COUNT_MESSAGE("시도할 횟수는 몇 회인가요?");

    InputViewMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
