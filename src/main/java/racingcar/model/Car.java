package racingcar.model;

public record Car(String name) {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String WHITE_SPACE = " ";
    private static final String POSSIBLE_NAME_REGEX = "[a-zA-Z0-9]+";

    public Car {
        validate(name);
    }

    private void validate(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 1자 이상 5자 이하만 가능해요.");
        }
        if (hasWhitespace(name)) {
            throw new IllegalArgumentException("자동차의 이름에는 공백이 포함될 수 없어요.");
        }
        if (hasInvalidCharacters(name)) {
            throw new IllegalArgumentException("자동차의 이름에는 알파벳과 숫자만 사용할 수 있어요.");
        }
    }

    private boolean hasWhitespace(String name) {
        return name.contains(WHITE_SPACE);
    }

    private boolean hasInvalidCharacters(String name) {
        return !name.matches(POSSIBLE_NAME_REGEX);
    }
}
