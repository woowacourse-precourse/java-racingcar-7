package racingcar.model.vo;

public record CarName(String name) {

    private static final int MAX_NAME_LENGTH = 5;

    public CarName {
        validateLessThanFiveCharacters(name);
        validateAlphabeticString(name);
    }

    private void validateLessThanFiveCharacters(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private void validateAlphabeticString(String name) {
        if (name.isBlank() || !name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("이름은 영문자로 이루어져야 합니다.");
        }
    }

}
