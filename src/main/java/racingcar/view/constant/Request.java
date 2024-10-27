package racingcar.view.constant;

public enum Request {

    CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_NUMBER("시도할 횟수는 몇 회인가요?");

    private final String infoMessage;

    Request(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    @Override
    public String toString() {
        return infoMessage;
    }
}

