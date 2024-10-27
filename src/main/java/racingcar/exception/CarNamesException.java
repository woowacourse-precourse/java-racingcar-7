package racingcar.exception;

public class CarNamesException extends IllegalAccessError {
    public static final String MESSAGE_INVALID_DELIMITER = "자동차의 이름은 쉼표(,)로 구분해야 합니다.";
    public static final String MESSAGE_CAR_NAME_EMPTY = "자동차 이름이 비어 있습니다.";
    public static final String MESSAGE_DUPLICATE_CAR_NAME = "자동차 이름이 중복되었습니다.";
    public static final String MESSAGE_CAR_NAME_OVER_FIVE = "자동차 이름은 5자를 초과할 수 없습니다.";

    public CarNamesException(String errorMessage) {
        super(errorMessage);
    }
}
