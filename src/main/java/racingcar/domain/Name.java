package racingcar.domain;

public record Name(String value) {
    private static final int MAX_NAME_LENGTH = 5;

    public static Name from(String value) {
        validate(value);
        return new Name(value);
    }

    private static void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 공뱃일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

}
