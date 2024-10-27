package racingcar.message;

public enum RunMessage {
    INPUT_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    INPUT_ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?\n"),
    RESULT("\n실행 결과\n"),
    PRINT_CAR("%s : ");

    private final String message;


    RunMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
