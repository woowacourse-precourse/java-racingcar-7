package racingcar.message;

public enum RacingMessage implements Message {

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 횟수는 몇 회인가요?"),
    EXECUTE_RESULT("\n실행 결과"),
    CAR_POSITION("%s : %s"),
    FINAL_WINNERS("최종 우승자 : %s")
    ;

    public static final String CAR_POSITION_SYMBOL = "-";
    public static final String FINAL_WINNERS_DELIMITER = ", ";
    public static final String NEW_LINE = "\n";

    private final String message;

    RacingMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
