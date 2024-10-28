package racingcar.model;

public record Name(String name) {

    private static final String INVALID_EMPTY_MESSAGE = "이름에 빈 값을 입력할 수 없습니다.";
    private static final String INVALID_ALPHABETIC_MESSAGE = "이름은 영어로만 작성 가능합니다.";
    private static final String INVALID_LENGTH_MESSAGE = "이름은 5자 이하만 입력 가능합니다.";
    private static final String ALPHABETIC_REGEX = "^[a-zA-Z]+$";

    private static final int MAX_LENGTH = 5;

    public Name {
        validate(name);
    }

    private void validate(String name) {
        validateEmpty(name);
        validateAlphabetic(name);
        validateLength(name);
    }

    private void validateEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }
    }

    private void validateAlphabetic(String name) {
        if (!name.matches(ALPHABETIC_REGEX)) {
            throw new IllegalArgumentException(INVALID_ALPHABETIC_MESSAGE);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }
}
