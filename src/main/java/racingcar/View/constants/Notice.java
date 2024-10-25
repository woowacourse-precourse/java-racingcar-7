package racingcar.View.constants;

public enum Notice {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_NUMBER_OF_TRIALS("시도할 횟수는 몇 회인가요?");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
