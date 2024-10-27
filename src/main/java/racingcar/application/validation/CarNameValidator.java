package racingcar.application.validation;

public class CarNameValidator implements Validator {

    @Override
    public void validate(String string) {
        if (string == null || string.isBlank() || string.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (string.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
