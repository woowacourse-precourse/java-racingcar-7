package racingcar.message;

public enum InputRequestMessage {
    NAME_REQUEST_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_ATTEMPT_REQUEST_MESSAGE("시도할 횟수는 몇 회인가요?");

    String message;

    InputRequestMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
