package racingcar.global;

public enum Message {

    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ENTER_TRY_COUNT("시도할 횟수는 몇 회인가요?"),
    MOVE_FORWARD_RESULT("\n실행 결과"),
    WINNER("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}