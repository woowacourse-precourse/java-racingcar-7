package racingcar.Util.Message;

public enum IOMessage {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRIAL_COUNT("시도할 횟수는 몇 회인가요?"),
    RACING_RESULT("\n실행 결과"),
    SEPARATOR(" : "),
    NEW_LINE("\n"),
    RESULT_MESSAGE("최종 우승자 : ");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}