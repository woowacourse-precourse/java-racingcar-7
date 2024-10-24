package racingcar.model;

public record Name(String name) {

    private static final int NAME_MAX_SIZE = 5;

    public Name {
        validateNameIsBlank(name);
        validateNameLengthLongerThenMaxSize(name);
    }

    private void validateNameIsBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLengthLongerThenMaxSize(final String name) {
        if (name.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException("이름의 길이는 " + NAME_MAX_SIZE + "자 이하여야 합니다.");
        }
    }
}
