package racingcar.io.output;

public enum OutputMessage {
    PLAY_GAME_DESCRIPTION("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)"),
    HOW_MANY_TRY("시도할 횟수는 몇 회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    USER_PROGRESS("%s : %s"),
    WINNER("최종 우승자 : %s");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
