package racingcar.constant;

public enum CommonMessage {
    CAR_NAME_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분하며 최대 5개 까지 가능)"),
    ATTEMPT_PROMPT("시도할 횟수는 몇 회인가요?(최대 10회까지 가능)"),
    RACE_RESULT_START("실행 결과"),
    WINNERS_MESSAGE("최종 우승자 : "),
    ERROR_MESSAGE_PREFIX("오류: ");

    private final String message;

    CommonMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}