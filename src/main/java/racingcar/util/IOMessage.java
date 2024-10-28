package racingcar.util;

public enum IOMessage {
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRIAL_MESSAGE("시도할 횟수는 몇 회인가요?"),
    OUTPUT_RESULT_MESSAGE("최종 우승자 : ");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
