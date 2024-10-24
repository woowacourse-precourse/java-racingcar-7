package racingcar.domain.car;

public class Name {
    private static final Integer MAX_NAME_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z가-힣0-9\\s]+$";

    private final String name;

    public Name(String name) {
        this.name = name.trim();
        validate(name);
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateLength(name);
        validateRegex(name);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRegex(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

}
