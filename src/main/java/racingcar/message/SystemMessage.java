package racingcar.message;

public enum SystemMessage {
    REQUEST_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_ROUND_NUMBER("시도할 횟수는 몇 회인가요?"),
    GAME_RESULT("실행 결과"),
    GAME_WINNER("최종 우승자 : %s"),
    CURRENT_RESULT("%s : %S"),
    DISTANCE("-");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
