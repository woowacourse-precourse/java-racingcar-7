package racingcar.validator;

public class RaceCarValidator {
    private static final String ERROR_CAR_NAME_RANGE = "자동차 이름은 1~5자까지 허용합니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private RaceCarValidator() {
    }

    public static void validate(String name) {
        validateNameRange(name);
    }

    private static void validateNameRange(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_RANGE);
        }
    }
}