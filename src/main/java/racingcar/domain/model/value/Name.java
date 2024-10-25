package racingcar.domain.model.value;

public final class Name {

    private final String value;
    private static final String INVALID_NAME_LENGTH = "자동차의 이름은 5자 이하로 작성하여야 합니다.";

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private static void validate(String value) {
        if (value.isEmpty() || value.length() > 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
