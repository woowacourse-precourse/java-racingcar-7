package racingcar.validateName;

public class ValidateName {
    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
