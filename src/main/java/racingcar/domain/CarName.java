package racingcar.domain;

public class CarName {
    private static final String ERROR_MESSAGE_FOR_BLANK = "자동차 이름에 공백이 존재합니다. 프로그램을 종료합니다.";
    private static final String ERROR_MESSAGE_LESS_THAN_MIN_LENGTH = "자동차 이름의 길이가 0입니다. 프로그램을 종료합니다.";
    private static final String ERROR_MESSAGE_OVER_MAX_LENGTH = "자동차 이름이 5글자보다 깁니다. 프로그램을 종료합니다.";
    private static final String BLANK = " ";
    private static final int MAX_LENGTH = 5;
    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName from(String carName) {
        validate(carName);
        return new CarName(carName);
    }

    private static void validate(String carName) {
        validateBlank(carName);
        validateNoName(carName);
        validateOverLength(carName);
    }

    private static void validateBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_BLANK);
        }
    }

    private static void validateNoName(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LESS_THAN_MIN_LENGTH);
        }
    }

    private static void validateOverLength(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OVER_MAX_LENGTH);
        }
    }
}
