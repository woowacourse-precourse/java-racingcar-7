package racingcar.message;

public enum InfoMessage {
    REQUEST_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_NUMBER_MESSAGE("시도할 횟수는 몇 회인가요?"),
    STATUS_NOTIFICATION_MESSAGE("\n실행결과"),
    WINNER_NOTIFICATION_MESSAGE("최종 우승자 : ");

    private final String message;

    InfoMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
