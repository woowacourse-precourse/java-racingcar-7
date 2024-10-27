package racingcar.global.enums;

public enum PrintMessage {

    NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    COUNT_MESSAGE("시도할 횟수는 몇 회인가요?"),
    GAME_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : "),
    EMPTY_MESSAGE(""),
    ;

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
