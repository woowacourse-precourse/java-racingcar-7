package racingcar.enums;

public enum NotificationMessage {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ROUNDS("시도할 횟수는 몇 회인가요?"),
    FINAL_WINNERS("최종 우승자 : ");

    private final String message;

    NotificationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
