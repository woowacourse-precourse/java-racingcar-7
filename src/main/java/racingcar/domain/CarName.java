package racingcar.domain;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validate(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
