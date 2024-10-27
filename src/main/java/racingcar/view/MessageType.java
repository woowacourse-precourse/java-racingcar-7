package racingcar.view;

public enum MessageType {

    REQUEST_INPUT_STRING("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_INPUT_TRY_GAME_NUM("시도할 횟수는 몇 회인가요?"),
    RESPONSE_FINAL_WINNER("최종 우승자 : "),
    RESPONSE_RESULT("\n실행결과");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
