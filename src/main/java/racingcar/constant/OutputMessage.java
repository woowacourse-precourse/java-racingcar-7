package racingcar.constant;

public enum OutputMessage {
    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ENTER_ATTEMPTS("시도할 횟수는 몇 회인가요?"),
    RESULT_PREFIX("실행 결과"),
    WINNER_DELIMITER(", "),
    MOVEMENT_STATE_FORMAT("%s : %s%n"),
    WINNERS_ANNOUNCEMENT("최종 우승자 : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}