package racingcar.domain.racer;

public record CarName(String value) {

    public CarName {
        validate(value);
    }

    private void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
