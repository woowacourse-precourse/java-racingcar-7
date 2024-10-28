package racingcar.constant;

public enum OutputMessage {

    CAR_NAME_INPUT_GUIDE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_GUIDE("시도할 횟수는 몇 회인가요?"),
    NEW_LINE("\n"),
    PROGRESS_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : ");

    private final String message;


    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
