package racingcar.domain.car;

public class CarName {
    private static final int LENGTH_THRESHOLD = 5;
    private final String identifier;

    public static CarName of(String identifier) {
        return new CarName(identifier);
    }

    private CarName(String identifier) {
        validate(identifier);
        this.identifier = identifier;
    }

    private void validate(String identifier) {
        if (identifier.isEmpty()) {
            throw new IllegalArgumentException("Identifier cannot be empty");
        }
        if (identifier.isBlank()) {
            throw new IllegalArgumentException("Identifier cannot be blank");
        }
        if (identifier.length() > LENGTH_THRESHOLD) {
            throw new IllegalArgumentException("Identifier too long, must under : " + LENGTH_THRESHOLD);
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return identifier.equals(((CarName) o).identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
