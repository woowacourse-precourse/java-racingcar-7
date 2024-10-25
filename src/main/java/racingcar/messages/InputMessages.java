package racingcar.messages;

public enum InputMessages {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_ROUNDS("시도할 횟수는 몇 회인가요?")
    ;

    private final String messages;

    InputMessages(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }
}
