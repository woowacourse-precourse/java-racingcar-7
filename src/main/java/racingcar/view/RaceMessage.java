package racingcar.view;

public enum RaceMessage {
    CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_RACE_INPUT("시도할 회수는 몇회인가요?"),
    PRINT_RACE_RESULT("\n실행 결과\n"),
    PRINT_WINNER_FORMAT("최종 우승자 : ");

    private final String msg;

    RaceMessage(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
