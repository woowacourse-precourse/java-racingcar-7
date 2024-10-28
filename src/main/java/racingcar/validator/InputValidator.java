package racingcar.validator;

public class InputValidator {
    NameValidator nameValidator = new NameValidator();
    TryNumberValidator tryNumberValidator = new TryNumberValidator();

    public void validate(String name, String tryNumber) {
        nameValidator.NameValidate(name);
        tryNumberValidator.TryNumberValidate(tryNumber);
    }
}
