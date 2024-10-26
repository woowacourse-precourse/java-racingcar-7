package racingcar.domain;

import racingcar.view.InputForm;

import java.util.List;

public class InputFormValidator {
    public static void validate(InputForm inputForm) {
        validateInputName(inputForm.getInputNames());
        validateNames(inputForm.getNames());
    }

    private static void validateInputName(String inputNames) {
        if (inputNames.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백이 불가합니다.");
        }
    }

    private static void validateNames(List<String> names) {
        for (String name : names) {
            validateInputName(name);

            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
