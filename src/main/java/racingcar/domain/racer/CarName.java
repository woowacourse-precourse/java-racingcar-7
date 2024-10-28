package racingcar.domain.racer;

public record CarName(String value) {

    private static final int MAXIMUM_VALUE_LENGTH = 5;

    public static CarName from(String value) {
        validateCarName(value);
        return new CarName(value);
    }

    private static void validateCarName(String value) {
        validateNullOrEmpty(value);
        validateMaxLength(value);
    }

    private static void validateMaxLength(String value) {
        if (value.length() > MAXIMUM_VALUE_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
