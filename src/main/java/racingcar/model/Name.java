package racingcar.model;

public class Name {

    private final String name;

    public Name(final String name) {
        validateNotBlank(name);
        validateSize(name);
        this.name = name;
    }

    private void validateNotBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 null이거나 빈 문자열일 수 없습니다.");
        }
    }

    private void validateSize(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
