package racingcar.model;

public class Car {
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateCarNameLength(name);
        validateEmpty(name);
        validateOnlyLetters(name);
    }

    private void validateCarNameLength(String name) {
        if (IsNotValidNameLength(name)) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    private boolean IsNotValidNameLength(String name) {
        return name.length() > 5;
    }

    private void validateEmpty(String name) {
        if (isEmptyName(name)) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private boolean isEmptyName(String name) {
        return name.isBlank();
    }

    private void validateOnlyLetters(String name) {
        if (isValidOnlyLetters(name)) {
            throw new IllegalArgumentException("이름은 영문자만 포함해야 합니다.");
        }
    }

    private boolean isValidOnlyLetters(String name) {
        return !name.matches("[a-zA-Z]+");
    }
}
