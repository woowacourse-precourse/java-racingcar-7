package racingcar.service.validator.name;

public class InputNameLengthValidator implements InputNameValidator {
    @Override
    public void validate(String inputNames) {
        for (String inputName : splitInputNames(inputNames)) {
            validateLength(inputName);
        }
    }

    private void validateLength(String inputName) {
        if (isInputNameEmpty(inputName) || isInputNameOverFive(inputName)) {
            throw new IllegalArgumentException("이름의 길이 형식은 1자 이상, 5자 이하입니다.");
        }
    }

    private boolean isInputNameEmpty(String inputName) {
        return inputName.isEmpty();
    }

    private boolean isInputNameOverFive(String inputName) {
        return inputName.length() > 5;
    }
}
