package racingcar.domain.racer;

public record CarName(String value) {

    public static CarName from(String value) {
        validate(value);
        return new CarName(value);
    }

    private static void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
