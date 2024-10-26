package racingcar.util;

public class RacingCarStringValidator implements StringValidator {

    @Override
    public void validateLength(final String value, final int maxLength) {
        if (isExceedCarNameLength(value, maxLength)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void validateFormat(final String value) {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isExceedCarNameLength(final String name, final int maxLength) {
        return name.length() > maxLength;
    }
}
