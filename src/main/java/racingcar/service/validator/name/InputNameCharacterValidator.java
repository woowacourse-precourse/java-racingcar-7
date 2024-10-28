package racingcar.service.validator.name;

public class InputNameCharacterValidator implements InputNameValidator {
    private static final String INVALID_REGULAR_EXPRESSION = "^.*\\s+.*$";

    @Override
    public void validate(String inputNames) {
        for (String name : splitInputNames(inputNames)) {
            hasInvalidCharacter(name);
        }
    }

    private void hasInvalidCharacter(String inputName) {
        if (inputName.matches(INVALID_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("공백은 이름에 포함될 수 없습니다.");
        }
    }
}
