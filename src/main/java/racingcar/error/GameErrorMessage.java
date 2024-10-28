package racingcar.error;

public enum GameErrorMessage {
    NO_STARTED("출발한 자동차가 존재하지 않습니다. 다시 시도해 주세요");

    private final String message;

    GameErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
