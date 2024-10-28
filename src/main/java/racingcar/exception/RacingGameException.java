package racingcar.exception;

public enum RacingGameException {
    ROUND_IS_LESS_THAN_ONE("라운드는 1 이상이어야 합니다."),
    GAME_IS_END("게임이 종료되어 더이상 진행할 수 없습니다.");

    private final String message;

    RacingGameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
