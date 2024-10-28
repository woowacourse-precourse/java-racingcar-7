package view;

public enum Message {
    CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    RACE_COUNT_MESSAGE("시도할 횟수는 몇 회인가요?"),
    WINNER_IS("최종 우승자 : ");

    private String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
