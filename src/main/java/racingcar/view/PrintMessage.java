package racingcar.view;

public enum PrintMessage {

    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_CAR_MOVEMENT_MESSAGE("시도할 횟수는 몇 회인가요?"),
    LINE_SPACE(""),
    CAR_RACE_RESULT_MESSAGE("실행 결과"),
    CAR_RACE_WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
