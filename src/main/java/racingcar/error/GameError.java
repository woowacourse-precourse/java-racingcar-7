package racingcar.error;

public enum GameError {

    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_ATTEMPT_COUNT("시도 횟수는 1회 이상이어야 합니다."),
    INVALID_CAR_COUNT("자동차는 최소 2대 이상이어야 합니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INVALID_INPUT_FORMAT("유효하지 않은 입력 형식입니다."),
    EMPTY_CAR_NAME_INPUT("자동차 이름을 입력해야 합니다.");

    private final String message;

    GameError(String message) {
        this.message = message;
    }


    public String getMessage() {
        return this.message;
    }

}
