package racingcar.view;

public enum InfoMessage {

    CAR_NAMES_INSTRUCTION("자동차 이름을 입력해주세요. (이름은 쉼표(,) 기준으로 구분)");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
