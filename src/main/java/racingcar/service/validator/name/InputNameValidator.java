package racingcar.service.validator.name;

public interface InputNameValidator {
    void validate(String inputName);

    default String[] splitInputNames(String inputNames) {
        return inputNames.split(",");
    }
}
