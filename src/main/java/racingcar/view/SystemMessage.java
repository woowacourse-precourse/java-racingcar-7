package racingcar.view;

public enum SystemMessage {
    INPUT_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ROUND("시도할 횟수는 몇 회인가요?"),
    FINAL_RESULT("실행 결과");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
