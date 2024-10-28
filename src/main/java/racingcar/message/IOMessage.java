package racingcar.message;

public enum IOMessage {
    INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_MESSAGE("시도할 횟수는 몇 회인가요?"),
    OUTPUT_RESULT_MESSAGE("실행 결과"),
    CAR_MOVE_MESSAGE("%s : %s"),
    OUTPUT_MESSAGE("최종 우승자 : ");

    private String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
