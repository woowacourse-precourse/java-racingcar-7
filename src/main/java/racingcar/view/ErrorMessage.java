package racingcar.view;

public enum ErrorMessage {
    NAME_TOO_LONG("자동차 이름은 5자를 초과할 수 없습니다."),
    EMPTY_CAR_NAMES("자동차 이름은 비어 있을 수 없으며, 쉼표(,)로 구분되어야 합니다."),
    DUPLICATE_NAME("자동차 이름은 중복될 수 없습니다."),
    MINIMUM_CARS("경주할 자동차는 최소 2대 이상이어야 합니다."),
    INVALID_TRY_COUNT("시도 횟수는 양의 정수여야 합니다."),
    EMPTY_TRY_COUNT("시도 횟수는 비어 있을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
