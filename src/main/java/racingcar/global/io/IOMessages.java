package racingcar.global.io;

public enum IOMessages {
    CAR_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_INPUT_MESSAGE("시도할 횟수는 몇 회인가요?"),
    EXECUTION_OUTPUT_MESSAGE("실행 결과"),
    FINAL_WINNER_OUTPUT_MESSAGE("최종 우승자 :");

    private final String message;

    IOMessages(String message) {
        this.message = message;
    }
}
