package racingcar.constant;

public enum OutputMessage {

    CAR_NAME_INPUT_GUIDE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_GUIDE("시도할 횟수는 몇 회인가요?");

    private final String message;


    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
