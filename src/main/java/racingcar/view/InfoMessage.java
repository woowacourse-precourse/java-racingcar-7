package racingcar.view;

public enum InfoMessage {

    CAR_NAMES_INSTRUCTION("자동차 이름을 입력해주세요. (이름은 쉼표(,) 기준으로 구분)"),
    MOVING_COUNT_INSTRUCTION("시도할 회수는 몇 회인가요?");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
