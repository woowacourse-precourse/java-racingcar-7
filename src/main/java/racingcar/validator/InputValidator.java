package racingcar.validator;

public class InputValidator {

    public void validateCarNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 존재해야하며 5자 이하만 가능합니다.");
        }
    }
}
