package racingcar.application.util.validator;

import racingcar.application.util.io.vo.Input;

public final class InputValidator {

    private static final String COMMA = ",";
    private static final String REGEX_NAME_INPUT = "^[a-zA-Z가-힣0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|.<>\\/?]+";

    private InputValidator() {}

    public static void validateNamesInput(Input input) {
        if (input.value().startsWith(COMMA) || input.value().endsWith(COMMA)) {
            throw new IllegalArgumentException();
        }
        for (String nameInput : input.value().split(COMMA)) {
            if (!nameInput.trim().matches(REGEX_NAME_INPUT)) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void validateTrialInput(Input input) {
        try {
            Long.parseLong(input.value());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }


}
