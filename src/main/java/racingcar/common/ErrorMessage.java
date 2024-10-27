package racingcar.common;

public enum ErrorMessage {
    NOT_NULL_AND_NOT_BLANK("입력이 null이거나 빈 문자열일 수 없다."),
    NOT_DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    NOT_SAME_CARS_SIZE_AND_NUMBER_SIZE("자동차 수에 맞게 무작위 값이 입력되어야 합니다."),
    NOT_CAR_NAME_OVER_FIVE("자동차 이름은 5자 이하입니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
