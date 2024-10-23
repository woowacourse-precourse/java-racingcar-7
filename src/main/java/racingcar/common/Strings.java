package racingcar.common;

public enum Strings {
    REQUEST_RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_TRY_TIMES("시도할 횟수는 몇 회인가요?"),
    ;

    private String message;

    Strings(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
