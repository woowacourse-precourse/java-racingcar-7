package racingcar;

public enum Message {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 횟수는 몇 회인가요?"),
    RUN_RESULT("실행 결과");

    private final String message;
    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
