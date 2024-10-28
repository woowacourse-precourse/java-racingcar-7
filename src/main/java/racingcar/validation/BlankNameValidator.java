package racingcar.validation;

import racingcar.error.ErrorMessage;

import java.util.ArrayList;

public class BlankNameValidator {
    private BlankNameValidator() {}

    public static void validate(ArrayList<String> carNames) {
        for(String name : carNames) {
            checkNameContainsBlank(name);
        }
    }

    private static void checkNameContainsBlank(String name) {
        for(int i = 0; i < name.length(); i++) {
            checkLetterIsBlank(name.charAt(i));
        }
    }

    private static void checkLetterIsBlank(char letter) {
        if(letter == ' ') {
            ErrorMessage.printNameWithBlankError();
            throw new IllegalArgumentException();
        }
    }

}
