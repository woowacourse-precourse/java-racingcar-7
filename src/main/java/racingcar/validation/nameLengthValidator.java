package racingcar.validation;

import racingcar.error.ErrorMessage;

import java.util.ArrayList;

public class nameLengthValidator {
    private nameLengthValidator() {}

    public static void validate(ArrayList<String> carNames) {
        for (String carName : carNames) {
            checkLengthIsOverFive(carName);
        }
    }

    private static void checkLengthIsOverFive(String carName) {
        if(carName.length() > 5) {
            ErrorMessage.printNameLengthOverFiveError();
            throw new IllegalArgumentException();
        }
    }
}
