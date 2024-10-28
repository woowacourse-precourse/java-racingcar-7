package racingcar.message;

public enum CarRaceMessage {

    REQUEST_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_LAPS("시도할 횟수는 몇 회인가요?"),
    EXECUTION_RESULT("\n실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    CarRaceMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
