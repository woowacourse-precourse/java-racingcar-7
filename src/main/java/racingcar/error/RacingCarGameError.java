package racingcar.error;

public enum RacingCarGameError {

    // validator
    INVALID_CAR_NAME_LENGTH("자동차 이름의 길이가 유효하지 않습니다."),
    INVALID_MOVE_COUNT("자동차의 이동 횟수가 유효하지 않습니다."),
    INVALID_NUMBER_OF_CAR("자동차의 수가 유효하지 않습니다."),
    DUPLICATION_CAR_NAME("자동차 이름이 중복되었습니다."),

    // input view
    INVALID_INPUT_FORMAT("유효하지 않은 입력 형식입니다.");

    private String message;


    RacingCarGameError(String message) {
        this.message = message;
    }


    public String getMessage() {
        return this.message;
    }


}
