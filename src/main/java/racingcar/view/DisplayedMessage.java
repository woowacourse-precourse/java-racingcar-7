package racingcar.view;

public enum DisplayedMessage {

    INPUT_CARS_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT_MESSAGE("시도할 횟수는 몇 회인가요?"),

    OUTPUT_EXECUTE_RESULT_TEXT("\n실행 결과"),
    OUTPUT_WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    DisplayedMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
