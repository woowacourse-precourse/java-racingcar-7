package racingcar.constant;

public enum ServiceMessage {
    START_MESSAGE_RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"),
    START_MESSAGE_RACING_COUNT("시도할 횟수는 몇 회인가요?"),
    PLAYING_RACING("실행 결과"),
    WINNER_USER("최종 우승자 : ");


    private final String message;

    ServiceMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
