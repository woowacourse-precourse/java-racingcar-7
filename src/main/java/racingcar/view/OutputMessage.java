package racingcar.view;

public enum OutputMessage {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_MOVES("시도할 횟수는 몇 회인가요?"),
    RESULT_SEPARATOR(" : "),
    MOVE_MARK("-"),
    WINNER("최종 우승자");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
