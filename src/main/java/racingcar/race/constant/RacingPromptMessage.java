package racingcar.race.constant;

public enum RacingPromptMessage {
    CAR_NAME_TO_ENTER_TEXT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_ATTEMPTS_TO_ENTER_TEXT("시도할 횟수는 몇 회인가요?"),
    EXECUTION_RESULT_TEXT(System.lineSeparator() + "실행결과"),
    WINNER_RESULT_TEXT("최종 우승자 : ");

    private final String message;

    RacingPromptMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
