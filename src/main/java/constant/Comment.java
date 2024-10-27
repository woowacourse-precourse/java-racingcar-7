package constant;

public enum Comment {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요. (이름은 쉼(,) 기준으로 구분)"),
    COUNT_INPUT_MESSAGE("시도할 횟수는 몇 회인가요?"),
    RESULT_MESSAGE("실행 결과\n"),
    WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    Comment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
