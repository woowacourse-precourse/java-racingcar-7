package racingcar.exception;

import static racingcar.domain.car.Car.MAXIMUM_NAME_LENGTH;
import static racingcar.domain.racing.Racing.MINIMUM_TRY_COUNT;
import static racingcar.domain.car.RacingCars.MINIMUM_CAR_COUNT;

public enum Exception {
    DUPLICATE_NAME("자동차 이름은 중복될 수 없습니다."),
    NOT_ENOUGH_CARS("자동차 경주는 자동차가 최소 "+ MINIMUM_CAR_COUNT +"대 이상이어야 가능합니다."),
    NOT_POSITIVE_NUMBER("시도 횟수는 " + MINIMUM_TRY_COUNT + "이상만 가능합니다."),
    EMPTY_NAME("이름은 비거나 공백일 수 없습니다."),
    INVALID_NAME_LENGTH("이름은 " + MAXIMUM_NAME_LENGTH + "자 이내만 가능 합니다."),
    INVALID_TRY_COUNT("시도 횟수는 일정 크기의 숫자로 입력하여야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
