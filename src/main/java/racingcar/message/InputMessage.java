package racingcar.message;

public enum InputMessage {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_NUM_INPUT_MESSAGE("시도할 횟수는 몇 회인가요?");

    private final String message;

    public String getMessage() {
        return message;
    }

    InputMessage(String message) {
        this.message = message;
    }
}
