package racingcar.view;

public enum ViewMessages {

    CAR_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_INPUT_MESSAGE("시도할 회수는 몇 회인가요?"),
    OUTPUT_MESSAGE("\n실행 결과"),
    WINNER_OUTPUT_MESSAGE("최종 우승자 : ");

    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
